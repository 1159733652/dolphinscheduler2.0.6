package org.apache.dolphinscheduler.spi.utils;

import org.apache.dolphinscheduler.spi.task.paramparser.PlaceholderUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ZipperWatchUtils {
    private static final Logger logger = LoggerFactory.getLogger(ZipperWatchUtils.class);

    private static final String symbolPointStr = ".";
    private static final String symbolCommaStr = ",";

    private static final String leaveBlankSpace = " ";

    private static final String semicolon = ";";

    private static final String dataBaseAlias = "a";

    private static final String insetInto = "insert into ";

    private static final String insetOverWrite = "insert overwrite table ";
    private static final String select = "select ";

    private static final String from = "from ";
    private static final String where = "where ";
    private static final String union_all = "union all ";

    private static final String group_by = "group by ";

    private static final String truncate_table = "truncate table ";

    private static final String as = " as ";

    /**
     * 生成拉链表sql并执行
     * @param dataBaseNmae hive数据库
     * @param hisDataTale   历史表
     * @param allDataTable  全量表
     * @param url hive地址
     * @param user hive用户名
     * @param password hive密码
     */
    private static void zipperTableExecution(String dataBaseNmae, String hisDataTale, String allDataTable, String url, String user, String password) {
        Connection connection = null;
        try {
            // 连接hive
            connection = ConnHiveUtils.hiveConnection(url, user, password);
            if (null == connection) {
                logger.info("The obtained hive connection is null!" );
                return;
            }

            // 获得临时表表名
            String tempTable2 = hisDataTale + "_tmp2";
            String tempTable3 = hisDataTale + "_tmp3";

            // 库.表
            String DataBaseAndTableTemp2 = dataBaseNmae + symbolPointStr + tempTable2;
            String DataBaseAndTableTemp3 = dataBaseNmae + symbolPointStr + tempTable3;
            String DataBaseAndHisTable = dataBaseNmae + symbolPointStr + hisDataTale;
            String DataBaseAndAllDataTable = dataBaseNmae + symbolPointStr + allDataTable;
            // 创建hive连接
            Statement stmt = connection.createStatement();

            // 获取全量表 字段名和字段类型
            Map<String, String> allColumAndTypeMap = getColumAndDataType(allDataTable, stmt);
            if (null == allColumAndTypeMap || allColumAndTypeMap.size() == 0) {
                logger.info("Get field name and field type are null!");
                return;
            }
            // 获取临时表二 字段名和字段类型
            Map<String, String> columAndDataTypeTmp2 = getColumAndDataType(tempTable2,stmt);
            if (null == columAndDataTypeTmp2 || columAndDataTypeTmp2.size() == 0) {
                logger.error("获取临时表字段为空，表名："+tempTable2);
                return;
            }
            // 获取全量表字段
            List<String> colList = getColList(allColumAndTypeMap);
            // 获临时表二取字段
            List<String> colListTmp2 = getColList(columAndDataTypeTmp2);

            // 定义存放sql的数组
            String[] storeSql = new String[10];

            // 拉链表执行逻辑
            // 1、清空临时表
            String trunactTemp2Sql = truncate_table+DataBaseAndTableTemp2+semicolon;
            String trunactTemp3Sql = truncate_table+DataBaseAndTableTemp3+semicolon;
            storeSql[0] = trunactTemp2Sql;
            storeSql[1] = trunactTemp3Sql;

            // 2、昨日失效数据录入临时表3
            // 拼接表字段
            String cloumStr = spliceTableFields(colList);
            String invalidYesterdaySql = insetInto + DataBaseAndTableTemp3 + leaveBlankSpace +
                    select + cloumStr + leaveBlankSpace +
                    from + DataBaseAndHisTable + leaveBlankSpace + dataBaseAlias + leaveBlankSpace +
                    where + dataBaseAlias + symbolPointStr +"is_current=0" + semicolon;
            storeSql[2] = invalidYesterdaySql;

            // 3、当日数据+昨日有效数据处理后录入临时表2
            // 选择表字段
            String chooseFilds = spliceTableFields4(colList);
            //  获取表union1  历史有效
            String union1 = select + cloumStr + ",1 as is_old, 0 as is_new,'${pre_data_date}' as deal_day" + leaveBlankSpace +
                    from + DataBaseAndHisTable + leaveBlankSpace + dataBaseAlias + leaveBlankSpace +
                    where + "a.is_current='1'" + leaveBlankSpace;
            //  获取表union2  当日数据
            String cloumStr2 = spliceTableFields2(colList);
            String union2 = select + cloumStr2 + "0 as is_old, 1 as is_new,'${data_date}' as deal_day" + leaveBlankSpace +
                    from + DataBaseAndAllDataTable + leaveBlankSpace + dataBaseAlias + leaveBlankSpace +
                    where + "a.sum_date='${data_date}'" + leaveBlankSpace;
            String groupBySqlFields = spliceTableFields3(colList);
            String dayAndYesterdayValidDataSql = insetInto + DataBaseAndTableTemp2 + leaveBlankSpace +
                    select + chooseFilds + leaveBlankSpace +
                    from + "(" + union1 + leaveBlankSpace +
                    union_all + union2 + ")" + leaveBlankSpace + dataBaseAlias + leaveBlankSpace +
                    group_by + groupBySqlFields + semicolon;
            // 对自定义参数进行替换
            String newDayAndYesterdayValidDataSql = customParameters(dayAndYesterdayValidDataSql);
            storeSql[3] = newDayAndYesterdayValidDataSql;

            // 4、临时表2中当日新增记录录入临时表3
            String cloumStr5 = spliceTableFields3(colList);
            String dayDataTemp2ToTemp3Sql = insetInto + DataBaseAndTableTemp3 + leaveBlankSpace +
                    select + "a.deal_day as change_inure_date,'20991231' as change_expire_date,'1' as is_current," +
                    cloumStr5 + leaveBlankSpace +
                    from + DataBaseAndTableTemp2 + leaveBlankSpace + dataBaseAlias + leaveBlankSpace +
                    where + "a.is_old=0 and a.is_new=1"+semicolon;
            storeSql[4] = dayDataTemp2ToTemp3Sql;

            // 5、临时表2中留存用户录入临时表3
            String retainUsersDataTemp2ToTemp3Sql = insetInto + DataBaseAndTableTemp3 + leaveBlankSpace +
                    select + cloumStr +
                    from + DataBaseAndTableTemp2 + leaveBlankSpace + dataBaseAlias +
                    where + "a.is_old=1 and a.is_new=1"+semicolon;
            storeSql[5] = retainUsersDataTemp2ToTemp3Sql;

            // 6、临时表2中当日不存在用户录入临时表3
            String cloumStr6 = spliceTableFields5(colListTmp2);
            String noExixtUsersDataTemp2ToTemp3Sql = insetInto + DataBaseAndTableTemp3 + leaveBlankSpace +
                    select + cloumStr6 + leaveBlankSpace +
                    from + DataBaseAndTableTemp2 + leaveBlankSpace + dataBaseAlias + leaveBlankSpace +
                    where + "a.is_old=1 and a.is_new=0"+semicolon;
            storeSql[6] = noExixtUsersDataTemp2ToTemp3Sql;

            // 7、清空拉链表
            String truncateHisTableSql = truncate_table+DataBaseAndHisTable+semicolon;
            storeSql[7] = truncateHisTableSql;

            // 8、失效用户录入
            String cloumStr7 = spliceTableFields6(colList);
            String invalidUserEntrySql = insetOverWrite + DataBaseAndHisTable + leaveBlankSpace + "partition(is_current_flag='0')" + leaveBlankSpace +
                    select + cloumStr7 + leaveBlankSpace +
                    from + DataBaseAndTableTemp3 + leaveBlankSpace + dataBaseAlias + leaveBlankSpace +
                    where + "a.is_current='0'"+ semicolon;
            storeSql[8] = invalidUserEntrySql;

            // 9、有效用户录入
            String validUserEntrySql = insetOverWrite + DataBaseAndHisTable + leaveBlankSpace + "partition(is_current_flag='1')" + leaveBlankSpace +
                    select + cloumStr + leaveBlankSpace +
                    from + DataBaseAndTableTemp3 + leaveBlankSpace + dataBaseAlias + leaveBlankSpace +
                    where + "a.is_current='1'"+semicolon;
            storeSql[9] = validUserEntrySql;

            // 打印所有sql日志
            logger.info("所有执行sql为："+ Arrays.toString(storeSql));

            // 按顺序执行所有sql
            ResultSet rs = null;
            for (int i = 0; i < storeSql.length; i++) {
                rs = stmt.executeQuery(storeSql[i]);
                logger.info("sql语句为" + storeSql[i] + "的执行结果为：" + rs);
            }

        } catch (SQLException e) {
            System.out.println("SQLException" + e);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }

    private static List<String> getColList(Map<String, String> map){
        List<String> colList = new ArrayList<String>();
        for (Map.Entry<String, String> en : map.entrySet()) {
            colList.add(en.getKey()); // 获取key
        }
        return colList;
    }

    /**
     * 拼接表字段信息
     * @param colList colList
     * @return str
     */
    private static String spliceTableFields6(List<String> colList) {
        StringBuilder sqlStr = new StringBuilder();
        for (String temp : colList) {
            if ("change_inure_date".equals(temp)) {
                sqlStr.append("distinct  ").append(dataBaseAlias).append(symbolPointStr).append(temp).append(symbolCommaStr);
                continue;
            }
            sqlStr.append(dataBaseAlias).append(symbolPointStr).append(temp).append(symbolCommaStr);
        }
        return sqlStr.substring(0, sqlStr.length()-1);
    }


    /**
     * 拼接表字段信息
     * @param colList colList
     * @return str
     */
    private static String spliceTableFields5(List<String> colList) {
        StringBuilder sqlStr = new StringBuilder();
        for (String temp : colList) {
            if ("is_old".equals(temp)) {
                continue;
            } else if ("is_new".equals(temp)) {
                continue;
            } else if ("change_expire_date".equals(temp)) {
                continue;
            }
            if ("deal_day".equals(temp)) {
                sqlStr.append(dataBaseAlias).append(symbolPointStr).append(temp).append(as).append("change_expire_date").append(symbolCommaStr);
                continue;
            }
            if ("is_current".equals(temp)) {
                sqlStr.append("'0'").append(as).append(temp).append(symbolCommaStr);
                continue;
            }
            sqlStr.append(dataBaseAlias).append(symbolPointStr).append(temp).append(symbolCommaStr);
        }
        return sqlStr.substring(0, sqlStr.length()-1);
    }

    /**
     * 拼接表字段信息
     * @param colList colList
     * @return str
     */
    private static String spliceTableFields3(List<String> colList) {
        StringBuilder sqlStr = new StringBuilder();
        for (String temp : colList) {
            if ("change_inure_date".equals(temp) || "change_expire_date".equals(temp) || "is_current".equals(temp)) {
                continue;
            }
            sqlStr.append(dataBaseAlias).append(symbolPointStr).append(temp).append(symbolCommaStr);
        }
        String sql = sqlStr.toString();
        return sql.substring(0,sql.length()-1);
    }

    /**
     * 拼接表字段信息
     * @param colList colList
     * @return str
     */
    private static String spliceTableFields2(List<String> colList) {
        StringBuilder sqlStr = new StringBuilder();
        for (String temp : colList) {
            if ("change_inure_date".equals(temp) || "change_expire_date".equals(temp) || "is_current".equals(temp)) {
                temp = null;
                sqlStr.append(temp).append(leaveBlankSpace).append(as).append(temp).append(symbolCommaStr);
                continue;
            }
            sqlStr.append(dataBaseAlias).append(symbolPointStr).append(temp).append(symbolCommaStr);
        }
        return sqlStr.toString();
    }


    /**
     * 拼接表字段信息
     * @param colList colList
     * @return str
     */
    private static String spliceTableFields4(List<String> colList) {
        StringBuilder sqlStr = new StringBuilder();
        for (String temp : colList) {
            if ("change_inure_date".equals(temp) || "change_expire_date".equals(temp) || "is_current".equals(temp)) {
                sqlStr.append("max(").append(dataBaseAlias).append(symbolPointStr).append(temp).append(")").append(leaveBlankSpace).append(as).append(leaveBlankSpace).append(temp).append(symbolCommaStr);
                continue;
            }
            sqlStr.append(dataBaseAlias).append(symbolPointStr).append(temp).append(symbolCommaStr);
        }
        sqlStr.append("max(a.is_old) as is_old, max(a.is_new) as is_new,max(a.deal_day) as deal_day");
        return sqlStr.toString();
    }

    /**
     * 拼接表字段信息
     * @param colList colList
     * @return str
     */
    private static String spliceTableFields(List<String> colList) {
        StringBuilder sqlStr = new StringBuilder();
        for (String s : colList) {
            sqlStr.append(dataBaseAlias).append(symbolPointStr).append(s).append(symbolCommaStr);
        }
        String newStr = sqlStr.toString();
        return newStr.substring(0,newStr.length()-1);
    }

    // 根据表名获取字段和字段类型
    private static Map<String, String> getColumAndDataType(String tableName, Statement stmt) {
        // 保证获取字段顺序
        Map<String, String> allColumAndTypeMap = new LinkedHashMap<>();
        try {
            // 获取表字段信息
            ResultSet rs = stmt.executeQuery("describe " + tableName + ";");
            if (null == rs) {
                System.out.println("get table colum message error!" + rs);
                return allColumAndTypeMap;
            }
            while (rs.next()) {
                String colName = rs.getString("col_name");
                if (null == colName) {
                    continue;
                }
                allColumAndTypeMap.put(colName, rs.getString("data_type"));
            }
            return allColumAndTypeMap;
        } catch (SQLException e) {
            logger.error("SQLException" + e);
        }
        return allColumAndTypeMap;
    }
    // 处理语句中的字段自定义参数替换
    private static String customParameters(String sql) {
        if (StringUtils.isEmpty(sql)) {
            return "";
        }
        Map<String, String> parameterMap = NewLandCustomVariableValueUtils.getVariableValues(new Date());
        if (!parameterMap.isEmpty()) {
            // replace variable ${} form,refers to the replacement of system variables and custom variables
            sql = PlaceholderUtils.replacePlaceholders(sql, parameterMap, true);
        }
        return sql;
    }
}
