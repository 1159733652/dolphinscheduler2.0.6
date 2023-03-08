/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.spi.utils;

/**
 * constants
 */
public class Constants {
    private Constants() {
        throw new IllegalStateException("Constants class");
    }

    /** alert plugin param field string **/
    public static final String STRING_PLUGIN_PARAM_FIELD = "field";
    /** alert plugin param name string **/
    public static final String STRING_PLUGIN_PARAM_NAME = "name";
    /** alert plugin param props string **/
    public static final String STRING_PLUGIN_PARAM_PROPS = "props";
    /** alert plugin param type string **/
    public static final String STRING_PLUGIN_PARAM_TYPE = "type";
    /** alert plugin param title string **/
    public static final String STRING_PLUGIN_PARAM_TITLE = "title";
    /** alert plugin param value string **/
    public static final String STRING_PLUGIN_PARAM_VALUE = "value";
    /** alert plugin param validate string **/
    public static final String STRING_PLUGIN_PARAM_VALIDATE = "validate";
    /** alert plugin param options string **/
    public static final String STRING_PLUGIN_PARAM_OPTIONS = "options";


    /** string true */
    public static final String STRING_TRUE = "true";
    /** string false */
    public static final String STRING_FALSE = "false";
    /** string yes */
    public static final String STRING_YES = "YES";
    /** string no */
    public static final String STRING_NO = "NO";

    /**
     * common properties path
     */
    public static final String COMMON_PROPERTIES_PATH = "/common.properties";

    /**
     * date format of yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * date format of yyyyMMddHHmmss
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * date format of yyyyMMddHHmmssSSS
     */
    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    public static final String SPRING_DATASOURCE_MIN_IDLE = "spring.datasource.minIdle";

    public static final String SPRING_DATASOURCE_MAX_ACTIVE = "spring.datasource.maxActive";

    public static final String SPRING_DATASOURCE_TEST_ON_BORROW = "spring.datasource.testOnBorrow";

    /**
     * java.security.krb5.conf
     */
    public static final String JAVA_SECURITY_KRB5_CONF = "java.security.krb5.conf";

    /**
     * java.security.krb5.conf.path
     */
    public static final String JAVA_SECURITY_KRB5_CONF_PATH = "java.security.krb5.conf.path";

    /**
     * hadoop.security.authentication
     */
    public static final String HADOOP_SECURITY_AUTHENTICATION = "hadoop.security.authentication";

    /**
     * hadoop.security.authentication
     */
    public static final String HADOOP_SECURITY_AUTHENTICATION_STARTUP_STATE = "hadoop.security.authentication.startup.state";

    /**
     * loginUserFromKeytab user
     */
    public static final String LOGIN_USER_KEY_TAB_USERNAME = "login.user.keytab.username";

    /**
     * loginUserFromKeytab path
     */
    public static final String LOGIN_USER_KEY_TAB_PATH = "login.user.keytab.path";

    /**
     * resource storage type
     */
    public static final String RESOURCE_STORAGE_TYPE = "resource.storage.type";

    /**
     * kerberos
     */
    public static final String KERBEROS = "kerberos";

    /**
     *  support hive datasource in one session
     */
    public static final String SUPPORT_HIVE_ONE_SESSION = "support.hive.oneSession";

    /**
     * driver
     */
    public static final String ORG_POSTGRESQL_DRIVER = "org.postgresql.Driver";
    public static final String COM_MYSQL_CJ_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String ORG_APACHE_HIVE_JDBC_HIVE_DRIVER = "org.apache.hive.jdbc.HiveDriver";
    public static final String COM_CLICKHOUSE_JDBC_DRIVER = "ru.yandex.clickhouse.ClickHouseDriver";
    public static final String COM_ORACLE_JDBC_DRIVER = "oracle.jdbc.OracleDriver";
    public static final String COM_SQLSERVER_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String COM_DB2_JDBC_DRIVER = "com.ibm.db2.jcc.DB2Driver";
    public static final String COM_PRESTO_JDBC_DRIVER = "com.facebook.presto.jdbc.PrestoDriver";


    /**
     * validation Query
     */
    public static final String POSTGRESQL_VALIDATION_QUERY = "select version()";
    public static final String MYSQL_VALIDATION_QUERY = "select 1";
    public static final String HIVE_VALIDATION_QUERY = "select 1";
    public static final String CLICKHOUSE_VALIDATION_QUERY = "select 1";
    public static final String ORACLE_VALIDATION_QUERY = "select 1 from dual";
    public static final String SQLSERVER_VALIDATION_QUERY = "select 1";
    public static final String DB2_VALIDATION_QUERY = "select 1 from sysibm.sysdummy1";
    public static final String PRESTO_VALIDATION_QUERY = "select 1";

    /**
     * jdbc url
     */
    public static final String JDBC_MYSQL = "jdbc:mysql://";
    public static final String JDBC_POSTGRESQL = "jdbc:postgresql://";
    public static final String JDBC_HIVE_2 = "jdbc:hive2://";
    public static final String JDBC_CLICKHOUSE = "jdbc:clickhouse://";
    public static final String JDBC_ORACLE_SID = "jdbc:oracle:thin:@";
    public static final String JDBC_ORACLE_SERVICE_NAME = "jdbc:oracle:thin:@//";
    public static final String JDBC_SQLSERVER = "jdbc:sqlserver://";
    public static final String JDBC_DB2 = "jdbc:db2://";
    public static final String JDBC_PRESTO = "jdbc:presto://";


    public static final String ADDRESS = "address";
    public static final String DATABASE = "database";
    public static final String JDBC_URL = "jdbcUrl";
    public static final String PRINCIPAL = "principal";
    public static final String OTHER = "other";
    public static final String ORACLE_DB_CONNECT_TYPE = "connectType";
    public static final String KERBEROS_KRB5_CONF_PATH = "javaSecurityKrb5Conf";
    public static final String KERBEROS_KEY_TAB_USERNAME = "loginUserKeytabUsername";
    public static final String KERBEROS_KEY_TAB_PATH = "loginUserKeytabPath";

    /**
     * DOUBLE_SLASH //
     */
    public static final String DOUBLE_SLASH = "//";

    /**
     * comma ,
     */
    public static final String COMMA = ",";

    /**
     * COLON :
     */
    public static final String COLON = ":";

    /**
     * AT SIGN
     */
    public static final String AT_SIGN = "@";

    /**
     * datasource encryption salt
     */
    public static final String DATASOURCE_ENCRYPTION_SALT_DEFAULT = "!@#$%^&*";
    public static final String DATASOURCE_ENCRYPTION_ENABLE = "datasource.encryption.enable";
    public static final String DATASOURCE_ENCRYPTION_SALT = "datasource.encryption.salt";


    /**
     * NewLand Custom variables
     */
    public static final String  PRE_MON_YEAR_NUMBER = "pre_mon_year_number";// 上月月份
    public static final String  DATA_SEC_END = "data_sec_end";// 数据时间-秒
    public static final String  DATA_SEC = "data_sec";// 数据时间-秒(不足补0)
    public static final String  DATA_MIN_END = "data_min_end";// 数据时间-分
    public static final String  DATA_MIN = "data_min";// 数据时间-分(不足补0)
    public static final String  DATA_HOUR_END = "data_hour_end";// 数据时间-时
    public static final String  DATA_HOUR = "data_hour";// 数据时间-时(不足补0)
    public static final String  DATA_DAY_END = "data_day_end";// 数据时间-日
    public static final String  DATA_DAY = "data_day";// 数据时间-日(不足补0)
    public static final String  DATA_MONTH_END = "data_month_end";// 数据时间-月
    public static final String  DATA_MONTH = "data_month";// 数据时间-月(不足补0)
    public static final String  DATA_YEAR_END = "data_year_end";// 数据时间-年(最后两位)
    public static final String  DATA_YEAR = "data_year";// 数据时间-年
    public static final String  RUN_DATE = "run_date";// 年月日
    public static final String  RUN_TIME = "run_time";// 年月日时分秒
    public static final String  CURRENT_TIME_MILLIS = "current_time_millis";// 当前毫秒时间
    public static final String  REDO_CNT = "redo_cnt";// 任务运行次数(从0计数)
    public static final String  REDO_CNT_PLUS_1 = "redo_cnt_plus_1";// 任务运行次数(从1计数)
    public static final String  DAY_NUMBER_CC = "day_number_cc";// 日，最前面补0  DD
    public static final String  STAT_DATE = "stat_date";// 日期YYYYMMDD
    public static final String  NEXT_DATE = "next_date";// 下一天YYYYMMDD
    public static final String  NEXT_DAY_NUMBER = "next_day_number";// 下一天_day_number DD
    public static final String  NEXT_2_DATE = "next_2_date";// 下2天 YYYYMMDD
    public static final String  DOUBLE_YEAR = "double_year";// 奇偶年
    public static final String  DOUBLE_MONTH = "double_month";// 奇偶月，最前面补0
    public static final String  DOUBLE_MONTH_D = "double_month_d";// 奇偶月
    public static final String  PARTITIONKEY_DAY_3 = "partitionkey_day_3";// 日3分区
    public static final String  PARTITIONKEY_DAY_400 = "partitionkey_day_400";// 日400分区
    public static final String  PARTITIONKEY_DAY_400_CC = "partitionkey_day_400_cc";// 日400分区，最前面补0
    public static final String  PARTITIONKEY_DAY_36_CC = "partitionkey_day_36_cc";// 日36分区，最前面补0
    public static final String  NEXT_PARTITIONKEY_DAY_36 = "next_partitionkey_day_36";// 下一天日36分区
    public static final String  NEXT_PARTITIONKEY_DAY_36_CC = "next_partitionkey_day_36_cc";// 下一天日36分区，最前面补0
    public static final String  PARTITIONKEY_DAY_90 = "partitionkey_day_90";// 日90分区
    public static final String  PARTITIONKEY_DAY_90_CC = "partitionkey_day_90_cc";// 日90分区，最前面补0
    public static final String  WEEK_NUM = "week_num";// 日星期几
    public static final String  LAST_DATE = "last_date";// 本月最后一天
    public static final String  LAST_DAY_NUMBER = "last_day_number";// 本月天数
    public static final String  PER_LAST_DATE = "per_last_date";// 上月最后一天
    public static final String  PRE_LAST_DAY_NUMBER = "pre_last_day_number";// 上月天数
    public static final String  MON_NUMBER12 = "mon_number12";// 12月
    public static final String  MON_NUMBER12_CC = "mon_number12_cc";// 12月，最前面补0
    public static final String  NEXT_MON_NUMBER12 = "next_mon_number12";// 下一天12月
    public static final String  NEXT_MON_NUMBER12_CC = "next_mon_number12_cc";// 下一天12月，最前面补0
    public static final String  PRE_MON_NUMBER12 = "pre_mon_number12";// 上月的月份
    public static final String  PRE_MON_NUMBER12_CC = "pre_mon_number12_cc";// 上月的月份，最前面补0
    public static final String  PRE_MON_DOUBLE_YEAR = "pre_mon_double_year";// 上月的奇偶年
    public static final String  PARTITIONKEY_MON_7 = "partitionkey_mon_7";// 月7分区
    public static final String  PARTITIONKEY_MON_25_PRE = "partitionkey_mon_25_pre";// 上月25分区
    public static final String  PARTITIONKEY_MON_25_CC_PRE = "partitionkey_mon_25_cc_pre";// 上月25分区，最前面补0
    public static final String  PRE_DAY_NUMBER = "pre_day_number";// 上一天day_number
    public static final String  PRE_DATE = "pre_date";// 上一天日期
    public static final String  PRE_DOUBLE_MONTH = "pre_double_month";// 前一天的奇偶月，最前面补0
    public static final String  PRE_DOUBLE_MONTH_D = "pre_double_month_d";// 前一天的奇偶月
    public static final String  PARTITIONKEY_MON_3 = "partitionkey_mon_3";// 月3分区
    public static final String  THREE_MONTH = "three_month";// 3月,格式01/02/03(1月为01)
    public static final String  PRE_DOUBLE_YEAR = "pre_double_year";// 上月的奇偶年
    public static final String  STAT_MONTH = "stat_month";// 月份
    public static final String  PARTITIONKEY_MON_25 = "partitionkey_mon_25";// 月25分区
    public static final String  PARTITIONKEY_MON_25_CC = "partitionkey_mon_25_cc";// 月25分区，最前面补0
    public static final String  FIVE_YEAR = "five_year";// 5年,,格式01/02/03/04/05
    public static final String  PRE_DAY_INMONTH = "pre_day_inmonth";// 本月中前一天日期
    public static final String  V_FIVE_YEAR_PREY = "v_five_year_preY";// 上一年五年分表，格式01/02/03/04/05
    public static final String  V_PARTITION_KEY_60_CC = "v_partition_key_60_cc";// 月变量60个月分区补0
    public static final String  V_PARTITION_KEY_60_PRE1_CC = "v_partition_key_60_pre1_cc";// 上个月60分区cc
    public static final String  V_LAST_YEAR_FIVE = "v_last_year_five";// 日：上月上一年五年分区
    public static final String  V_FIVE_YEAR_PRE3 = "v_five_year_pre3";// 三个月前五年分区/月变量：上3个月对应的五年分区
    public static final String  V_PRE_DAY400_DATE = "v_pre_day400_date";// 日变量，统计日期四百天之前的日期
    public static final String  V_PRE_MON60_MON = "v_pre_mon60_mon";// 月变量，取统计月份五年前的月份
    public static final String  V_PRE_YEAR_DAY = "v_pre_year_day";// 日变量 取去年同期（日）
    public static final String  V_PRE_YEAR_MON = "v_pre_year_mon";// 月变量 取去年同期（月）
    public static final String  PRE2_MON_YEAR_NUMBER = "pre2_mon_year_number";// 上上个月
    public static final String  PRE1_MON_YEAR_NUMBER = "pre1_mon_year_number";// 上一个月,YYYYMM
    public static final String  PRE_THREE_MONTH = "pre_three_month";// 上个月，三月分区
    public static final String  PARTITIONKEY_MON_120_CC = "partitionkey_mon_120_cc";// 月120分区,最前面补0
    public static final String  PARTITIONKEY_MON_120 = "partitionkey_mon_120";// 月120分区
    public static final String  PRE_DAY_400 = "pre_day_400";// 日：上一日400分区
    public static final String  V_LAST_YEAR = "v_last_year";// 日对应上一年
    public static final String  V_PARTITION_KEY_60 = "v_partition_key_60";// 月变量60个月分区
    public static final String  V_PARTITION_KEY_60_PRE1 = "v_partition_key_60_pre1";// 月变量 上一个月对应的60分区
    public static final String  V_FIVE_YEAR_PRE1 = "v_five_year_pre1";// 月上一月对应5年分区
    public static final String  V_FIVE_YEAR_PRE2 = "v_five_year_pre2";// 月上两月对应5年分区
    public static final String  V_NEXT_MONTH = "v_next_month";// 月下月
    public static final String  V_FIVE_YEAR_NEXT1 = "v_five_year_next1";// 月：下月五年分区
    public static final String  V_FIVE_YEAR_PREY2 = "v_five_year_preY2";// 年：前年对应的五年分区
    public static final String  NEXT1_MON_NUMBER12_CC = "next1_mon_number12_cc";// 月：下月MM
    public static final String  NEXT2_MON_NUMBER12_CC = "next2_mon_number12_cc";// 月：下下月MM
    public static final String  NEXT1_MON_YEAR_NUMBER = "next1_mon_year_number";// 月：下月YYYYMM
    public static final String  NEXT2_MON_YEAR_NUMBER = "next2_mon_year_number";// 月：下下月YYYYMM
    public static final String  PRE_DAY_THREE_MONTH = "pre_day_three_month";// 上一天所在月对应的3分区，取2位
    public static final String  PRE_DAY_MON_NUMBER12 = "pre_day_mon_number12";// 当前日前一天对应的月，取数字
    public static final String  PARTITIONKEY_DAY_40_CC = "partitionkey_day_40_cc";// 日变量:40分区
    public static final String  PRE_THREE_MONTH_7 = "pre_three_month_7";// 日变量：当前日对应的上一周三月分区
    public static final String  PARTITIONKEY_DAY_400_7 = "partitionkey_day_400_7";// 日变量：当前日对应的上一周400分区
    public static final String  PARTITIONKEY_MONTH_400 = "partitionkey_month_400";// 日变量：当前日对应的上一月同期400分区
    public static final String  V_PARTITION_KEY_60_PRE12 = "v_partition_key_60_pre12";// 月变量：当前月对应的上一年同期的60分区
    public static final String  V_PARTITION_KEY_60_PRE2 = "v_partition_key_60_pre2";// 月变量：上上月对应的60分区
    public static final String  PRE_YEAR_PARTITION_KEY_60_MON = "pre_year_partition_key_60_mon";// 月变量：上一年最后一个月对应的60分区
    public static final String  PRE1_MON_YEAR_NUMBER12 = "pre1_mon_year_number12";// 月变量：上一年最后一个月
    public static final String  PRE_YEAR_LAST_DATE = "pre_year_last_date";// 日变量：上一年最后一天
    public static final String  PARTITIONKEY_YEAR_400 = "partitionkey_year_400";// 日变量：当前日对应上一年同期的400分区
    public static final String  PRE1_MON_NUMBER12_CC = "pre1_mon_number12_cc";// 月变量：上1个月对应的12分区
    public static final String  PRE2_MON_NUMBER12_CC = "pre2_mon_number12_cc";// 月变量：上2个月对应的12分区
    public static final String  PRE3_MON_NUMBER12_CC = "pre3_mon_number12_cc";// 月变量：上3个月对应的12分区
    public static final String  PRE4_MON_NUMBER12_CC = "pre4_mon_number12_cc";// 月变量：上4个月对应的12分区
    public static final String  PRE5_MON_NUMBER12_CC = "pre5_mon_number12_cc";// 月变量：上5个月对应的12分区
    public static final String  V_FIVE_YEAR_PRE4 = "v_five_year_pre4";// 月变量：上4个月对应的五年分区
    public static final String  V_FIVE_YEAR_PRE5 = "v_five_year_pre5";// 月变量：上5个月对应的五年分区
    public static final String  V_FIVE_YEAR_PRE6 = "v_five_year_pre6";// 月变量：上6个月对应的五年分区

    public static final String  PRE_DATA_DATE = "pre_data_date";// 昨日
    public static final String  DATA_DATE = "data_date";// 当日
}
