package org.apache.dolphinscheduler.spi.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * CustomVariableValue
 */
public class NewLandCustomVariableValueUtils {
    private static final Logger logger = LoggerFactory.getLogger(NewLandCustomVariableValueUtils.class);

    private static final SimpleDateFormat BASE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final SimpleDateFormat Y_M_FORMAT = new SimpleDateFormat("yyyyMM");
    private static final SimpleDateFormat Y_M_D_FORMAT = new SimpleDateFormat("yyyyMMdd");

    private static SimpleDateFormat MM_FORMAT = new SimpleDateFormat("MM");
    private static SimpleDateFormat M_FORMAT = new SimpleDateFormat("M");

    private static final String BEGIN_DATE = "20000101";
    private static final String ZERO = "0";
    private static final String ZEROCC = "00";


    public static Map<String, String> getVariableValues(Date cronTime) {
        if (null == cronTime) {
            cronTime = new Date();
        }
        Map<String, String> resMap = new HashMap<>();
        resMap.put(Constants.PRE_MON_YEAR_NUMBER, getPreMonth(cronTime));
        resMap.put(Constants.DATA_SEC_END, getSecondDateS(cronTime));
        resMap.put(Constants.DATA_SEC, getSecondDateSS(cronTime));
        resMap.put(Constants.DATA_MIN_END, getMinDateM(cronTime));
        resMap.put(Constants.DATA_MIN, getMinDateMM(cronTime));
        resMap.put(Constants.DATA_HOUR_END, getHourDateH(cronTime));
        resMap.put(Constants.DATA_HOUR, getHourDateHH(cronTime));
        resMap.put(Constants.DATA_DAY_END, getDayDateD(cronTime));
        resMap.put(Constants.DATA_DAY, getDayDateDD(cronTime));
        resMap.put(Constants.DATA_MONTH_END, getMonthDateM(cronTime));
        resMap.put(Constants.DATA_MONTH, getMonthDateMM(cronTime));
        resMap.put(Constants.DATA_YEAR_END, getYearDateYY(cronTime));
        resMap.put(Constants.DATA_YEAR, getYearDateYYYY(cronTime));
        resMap.put(Constants.RUN_DATE, getSpecificDate(cronTime));
        resMap.put(Constants.RUN_TIME, getAllDate(cronTime));
        resMap.put(Constants.CURRENT_TIME_MILLIS, getCurrMillSecondTime(cronTime));
        resMap.put(Constants.REDO_CNT, "0");
        resMap.put(Constants.REDO_CNT_PLUS_1, "0");
        resMap.put(Constants.DAY_NUMBER_CC, getPreTDay(cronTime));
        resMap.put(Constants.STAT_DATE, getStatDate(cronTime));
        resMap.put(Constants.NEXT_DATE, getNextDate(cronTime));
        resMap.put(Constants.NEXT_DAY_NUMBER, getNextDayNumber(cronTime));
        resMap.put(Constants.NEXT_2_DATE, getNext2Date(cronTime));
        resMap.put(Constants.DOUBLE_YEAR, getJustParityYear(cronTime));
        resMap.put(Constants.DOUBLE_MONTH, getDoubleMonth(cronTime));
        resMap.put(Constants.DOUBLE_MONTH_D, getDoubleMonthD(cronTime));
        resMap.put(Constants.PARTITIONKEY_DAY_3, getPartitionKeyDay3(cronTime));
        resMap.put(Constants.PARTITIONKEY_DAY_400, get400Partition(cronTime));
        resMap.put(Constants.PARTITIONKEY_DAY_400_CC, getPartitionkeyDay400CC(cronTime));
        resMap.put(Constants.PARTITIONKEY_DAY_36_CC, getPartitionkeyDay36CC(cronTime));
        resMap.put(Constants.NEXT_PARTITIONKEY_DAY_36, getNextDay36Partition(cronTime));
        resMap.put(Constants.NEXT_PARTITIONKEY_DAY_36_CC, getNextPartitionkeyDay36CC(cronTime));
        resMap.put(Constants.PARTITIONKEY_DAY_90, get90DayPartition(cronTime));
        resMap.put(Constants.PARTITIONKEY_DAY_90_CC, getPartitionkeyDay90CC(cronTime));
        resMap.put(Constants.WEEK_NUM, getWeekNum(cronTime));
        resMap.put(Constants.LAST_DATE, getLastDayofMoth(cronTime));
        resMap.put(Constants.LAST_DAY_NUMBER, getLastDayNumber(cronTime));
        resMap.put(Constants.PER_LAST_DATE, getLastDayofPreMoth(cronTime));
        resMap.put(Constants.PRE_LAST_DAY_NUMBER, getPreLastDayNumber(cronTime));
        resMap.put(Constants.MON_NUMBER12, getMonNumber12(cronTime));
        resMap.put(Constants.MON_NUMBER12_CC, getMonNumber12CC(cronTime));
        resMap.put(Constants.NEXT_MON_NUMBER12, getNextMonNumber12(cronTime));
        resMap.put(Constants.NEXT_MON_NUMBER12_CC, getNextMonNumber12CC(cronTime));
        resMap.put(Constants.PRE_MON_NUMBER12, getPreMonNumber12(cronTime));
        resMap.put(Constants.PRE_MON_NUMBER12_CC, getPreMonNumber12CC(cronTime));
        resMap.put(Constants.PRE_MON_DOUBLE_YEAR, getPreMonDoubleYear(cronTime));
        resMap.put(Constants.PARTITIONKEY_MON_7, getPartitionkeyMon7(cronTime));
        resMap.put(Constants.PARTITIONKEY_MON_25_PRE, getPartitionkeyMon25Pre(cronTime));
        resMap.put(Constants.PARTITIONKEY_MON_25_CC_PRE, getPartitionkeyMon25CCPre(cronTime));
        resMap.put(Constants.PRE_DAY_NUMBER, getPreDayNumber(cronTime));
        resMap.put(Constants.PRE_DATE, getPreDate(cronTime));
        resMap.put(Constants.PRE_DOUBLE_MONTH, getPreDoubleMonth(cronTime));
        resMap.put(Constants.PRE_DOUBLE_MONTH_D, getPreDoubleMonthD(cronTime));
        resMap.put(Constants.PARTITIONKEY_MON_3, getPartitionKeyMon3(cronTime));
        resMap.put(Constants.THREE_MONTH, getThreeMonth(cronTime));
        resMap.put(Constants.PRE_DOUBLE_YEAR, getPreDoubleYear(cronTime));
        resMap.put(Constants.STAT_MONTH, getStatMonth(cronTime));
        resMap.put(Constants.PARTITIONKEY_MON_25, getPartitionKeyMon25(cronTime));
        resMap.put(Constants.PARTITIONKEY_MON_25_CC, getPartitionKeyMon25CC(cronTime));
        resMap.put(Constants.FIVE_YEAR, getFiveYear(cronTime));
        resMap.put(Constants.PRE_DAY_INMONTH, getPreDayInmonth(cronTime));
        resMap.put(Constants.V_FIVE_YEAR_PREY, getVFiveYearPreY(cronTime));
        resMap.put(Constants.V_PARTITION_KEY_60_CC, getVPartitionKey60CC(cronTime));
        resMap.put(Constants.V_PARTITION_KEY_60_PRE1_CC, getVPartitionKey60Pre1CC(cronTime));
        resMap.put(Constants.V_LAST_YEAR_FIVE, getVLastYearFive(cronTime));
        resMap.put(Constants.V_FIVE_YEAR_PRE3, getVFiveYearPre3(cronTime));
        resMap.put(Constants.V_PRE_DAY400_DATE, getVPreDay400Date(cronTime));
        resMap.put(Constants.V_PRE_MON60_MON, getVPreMon60Mon(cronTime));
        resMap.put(Constants.V_PRE_YEAR_DAY, getVPreYearDay(cronTime));
        resMap.put(Constants.V_PRE_YEAR_MON, getVPreYearMon(cronTime));
        resMap.put(Constants.PRE2_MON_YEAR_NUMBER, getPre2MonYearNumber(cronTime));
        resMap.put(Constants.PRE1_MON_YEAR_NUMBER, getPre1MonYearNumber(cronTime));
        resMap.put(Constants.PRE_THREE_MONTH, getPreThreeMonth(cronTime));
        resMap.put(Constants.PARTITIONKEY_MON_120_CC, getPartitionkeyMon120CC(cronTime));
        resMap.put(Constants.PARTITIONKEY_MON_120, getPartitionkeyMon120(cronTime));
        resMap.put(Constants.PRE_DAY_400, getPreDay400(cronTime));
        resMap.put(Constants.V_LAST_YEAR, getVLastYear(cronTime));
        resMap.put(Constants.V_PARTITION_KEY_60, getVPartitionKey60(cronTime));
        resMap.put(Constants.V_PARTITION_KEY_60_PRE1, getVPartitionKey60Pre1(cronTime));
        resMap.put(Constants.V_FIVE_YEAR_PRE1, getVFiveYearPre1(cronTime));
        resMap.put(Constants.V_FIVE_YEAR_PRE2, getVFiveYearPre2(cronTime));
        resMap.put(Constants.V_NEXT_MONTH, getVNextMonth(cronTime));
        resMap.put(Constants.V_FIVE_YEAR_NEXT1, getVFiveYearNext1(cronTime));
        resMap.put(Constants.V_FIVE_YEAR_PREY2, getVFiveYearPreY2(cronTime));
        resMap.put(Constants.NEXT1_MON_NUMBER12_CC, getNext1MonNumBer12CC(cronTime));
        resMap.put(Constants.NEXT2_MON_NUMBER12_CC, getNext2MonNumBer12CC(cronTime));
        resMap.put(Constants.NEXT1_MON_YEAR_NUMBER, getNext1MonYearNumber(cronTime));
        resMap.put(Constants.NEXT2_MON_YEAR_NUMBER, getNext2MonYearNumber(cronTime));
        resMap.put(Constants.PRE_DAY_THREE_MONTH, getPreDayThreeMonth(cronTime));
        resMap.put(Constants.PRE_DAY_MON_NUMBER12, getPreDayMonNumber12(cronTime));
        resMap.put(Constants.PARTITIONKEY_DAY_40_CC, getPartitionKeyDay40CC(cronTime));
        resMap.put(Constants.PRE_THREE_MONTH_7, getPreThreeMonth7(cronTime));
        resMap.put(Constants.PARTITIONKEY_DAY_400_7, getPartitionKeyDay4007(cronTime));
        resMap.put(Constants.PARTITIONKEY_MONTH_400, getPartitionKeyMonth400(cronTime));
        resMap.put(Constants.V_PARTITION_KEY_60_PRE12, getVPartitionKey60Pre12(cronTime));
        resMap.put(Constants.V_PARTITION_KEY_60_PRE2, getVPartitionKey60Pre2(cronTime));
        resMap.put(Constants.PRE_YEAR_PARTITION_KEY_60_MON, getPreYearPartitionKey60Mon(cronTime));
        resMap.put(Constants.PRE1_MON_YEAR_NUMBER12, getPre1MonYearNumber12(cronTime));
        resMap.put(Constants.PRE_YEAR_LAST_DATE, getPreYearLastDate(cronTime));
        resMap.put(Constants.PARTITIONKEY_YEAR_400, getPartitionKeyYear400(cronTime));
        resMap.put(Constants.PRE1_MON_NUMBER12_CC, getPre1MonNumber12CC(cronTime));
        resMap.put(Constants.PRE2_MON_NUMBER12_CC, getPre2MonNumber12CC(cronTime));
        resMap.put(Constants.PRE3_MON_NUMBER12_CC, getPre3MonNumber12CC(cronTime));
        resMap.put(Constants.PRE4_MON_NUMBER12_CC, getPre4MonNumber12CC(cronTime));
        resMap.put(Constants.PRE5_MON_NUMBER12_CC, getPre5MonNumber12CC(cronTime));
        resMap.put(Constants.V_FIVE_YEAR_PRE4, getVFiveYearPre4(cronTime));
        resMap.put(Constants.V_FIVE_YEAR_PRE5, getVFiveYearPre5(cronTime));
        resMap.put(Constants.V_FIVE_YEAR_PRE6, getVFiveYearPre6(cronTime));

        return resMap;
    }

    // 获取上月月份 ${pre_mon_year_number}
    private static String getPreMonth(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.MONTH, parseCalender.get(Calendar.MONTH) - 1);
            return Y_M_FORMAT.format(parseCalender.getTime());
        } catch (Exception e) {
            logger.error("Error pre_mon_year_number date" + e);
        }
        return "";
    }

    // 数据时间-秒  S  ${data_sec_end}
    private static String getSecondDateS(Date cronTime) {
        try {
            SimpleDateFormat S_FORMAT = new SimpleDateFormat("s");
            SimpleDateFormat SS_FORMAT = new SimpleDateFormat("ss");
            return S_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error data_sec_end date" + e);
        }
        return "";
    }

    // 数据时间-秒(不足补0)  SS   ${data_sec}
    private static String getSecondDateSS(Date cronTime) {
        try {
            SimpleDateFormat SS_FORMAT = new SimpleDateFormat("ss");
            return SS_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error data_sec date" + e);
        }
        return "";
    }

    // 数据时间-分 M  ${data_min_end}
    private static String getMinDateM(Date cronTime) {
        try {
            SimpleDateFormat M_FORMAT = new SimpleDateFormat("m");
            return M_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error data_min_end date" + e);
        }
        return "";
    }

    // 数据时间-分(不足补0) MM  ${data_min}
    private static String getMinDateMM(Date cronTime) {
        try {
            SimpleDateFormat MM_FORMAT = new SimpleDateFormat("mm");
            return MM_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error data_min date" + e);
        }
        return "";
    }

    // 数据时间-时 H  ${data_hour_end}
    private static String getHourDateH(Date cronTime) {
        try {
            SimpleDateFormat H_FORMAT = new SimpleDateFormat("H");
            return H_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error data_hour_end date" + e);
        }
        return "";
    }

    // 数据时间-时(不足补0) HH  ${data_hour}
    private static String getHourDateHH(Date cronTime) {
        try {
            SimpleDateFormat HH_FORMAT = new SimpleDateFormat("HH");
            return HH_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error data_hour date" + e);
        }
        return "";
    }

    // 数据时间-日 D  ${data_day_end}
    private static String getDayDateD(Date cronTime) {
        try {
            SimpleDateFormat D_FORMAT = new SimpleDateFormat("d");
            return D_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error data_day_end date" + e);
        }
        return "";
    }

    // 数据时间-日(不足补0) DD ${data_day}
    private static String getDayDateDD(Date cronTime) {
        try {
            SimpleDateFormat DD_FORMAT = new SimpleDateFormat("dd");
            return DD_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error data_day date" + e);
        }
        return "";
    }

    // 数据时间-月 M   ${data_month_end}
    private static String getMonthDateM(Date cronTime) {
        try {
            return M_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error data_month_end date" + e);
        }
        return "";
    }

    // 数据时间-月(不足补0) MM  ${data_month}
    private static String getMonthDateMM(Date cronTime) {
        try {
            return MM_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error data_month date" + e);
        }
        return "";
    }

    // 数据时间-年(最后两位) YY  ${data_year_end}
    private static String getYearDateYY(Date cronTime) {
        try {
            SimpleDateFormat YY_FORMAT = new SimpleDateFormat("YY");
            return YY_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error data_year_end date" + e);
        }
        return "";
    }

    // 数据时间-年 YYYY  ${data_year}
    private static String getYearDateYYYY(Date cronTime) {
        try {
            SimpleDateFormat YYYY_FORMAT = new SimpleDateFormat("YYYY");
            return YYYY_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error data_year date" + e);
        }
        return "";
    }

    // 年月日  YYYYMMDD  ${run_date}
    private static String getSpecificDate(Date cronTime) {
        try {
            return Y_M_D_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error run_date date" + e);
        }
        return "";
    }

    // 年月日时分秒 YYYYMMDDhhmmss  ${run_time}
    private static String getAllDate(Date cronTime) {
        try {
            return BASE_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Error run_time date" + e);
        }
        return "";
    }

    // 当前毫秒时间  ${current_time_millis}
    private static String getCurrMillSecondTime(Date cronTime) {
        try {
            return String.valueOf(cronTime.getTime());
        } catch (Exception e) {
            logger.error("Error current_time_millis date" + e);
        }
        return "";
    }

    // 日，最前面补0  DD ${day_number_cc}  时间偏移是T-1
    private static String getPreTDay(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.DAY_OF_MONTH, parseCalender.get(Calendar.DAY_OF_MONTH) - 1);
            return getDayDateDD(parseCalender.getTime());
        } catch (Exception e) {
            logger.error("Error day_number_cc date" + e);
        }
        return "";
    }

    // 日期YYYYMMDD  ${stat_date}  时间偏移是T-1
    private static String getStatDate(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.DAY_OF_MONTH, parseCalender.get(Calendar.DAY_OF_MONTH) - 1);
            return getSpecificDate(parseCalender.getTime());
        } catch (Exception e) {
            logger.error("Error stat_date date" + e);
        }
        return "";
    }

    // 下一天YYYYMMDD  ${next_date}  时间偏移是T-1
    private static String getNextDate(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.DAY_OF_MONTH, parseCalender.get(Calendar.DAY_OF_MONTH) + 1 - 1);
            return getSpecificDate(parseCalender.getTime());
        } catch (Exception e) {
            logger.error("Error next_date date" + e);
        }
        return "";
    }

    // 下一天_day_number    DD   ${next_day_number}   时间偏移是T-1
    private static String getNextDayNumber(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.DAY_OF_MONTH, parseCalender.get(Calendar.DAY_OF_MONTH) + 1 - 1);
            return getDayDateDD(parseCalender.getTime());
        } catch (Exception e) {
            logger.error("Error next_day_number date" + e);
        }
        return "";
    }

    // 下2天 YYYYMMDD  ${next_2_date}  时间偏移是T-1
    private static String getNext2Date(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.DAY_OF_MONTH, parseCalender.get(Calendar.DAY_OF_MONTH) + 2 - 1);
            return getSpecificDate(parseCalender.getTime());
        } catch (Exception e) {
            logger.error("Error next_2_date date" + e);
        }
        return "";
    }

    // 奇偶年 ${double_year}  时间偏移是T-1
    private static String getJustParityYear(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.YEAR, parseCalender.get(Calendar.YEAR) - 1);
            Integer yearDateYYYY = Integer.valueOf(getYearDateYYYY(parseCalender.getTime()));
            return yearDateYYYY % 2 == 0 ? "02" : "01";
        } catch (Exception e) {
            logger.error("Error double_year date" + e);
        }
        return "";
    }

    // 奇偶月，最前面补0  ${double_month}   时间偏移是T-1
    private static String getDoubleMonth(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.MONTH, parseCalender.get(Calendar.MONTH) - 1);
            Integer dayDate = Integer.valueOf(getMonthDateM(parseCalender.getTime()));
            return dayDate % 2 == 0 ? "02" : "01";
        } catch (Exception e) {
            logger.error("Error double_month date" + e);
        }
        return "";
    }

    //  奇偶月 奇月1  偶月2  ${double_month_d}
    private static String getDoubleMonthD(Date cronTime) {
        try {
            Integer dayDate = Integer.valueOf(getMonthDateM(cronTime));
            return dayDate % 2 == 0 ? "2" : "1";
        } catch (Exception e) {
            logger.error("Error double_month_d date" + e);
        }
        return "";
    }

    // 日3分区  ${partitionkey_day_3}  时间偏移是T-1
    private static String getPartitionKeyDay3(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.DAY_OF_MONTH, parseCalender.get(Calendar.DAY_OF_MONTH) - 1);
            Date beginDate = Y_M_D_FORMAT.parse(BEGIN_DATE);
            long abs = Math.abs(parseCalender.getTime().getTime() - beginDate.getTime());
            double ceil = Math.ceil(abs / (1000 * 3600 * 24));
            if (ceil > 3) {
                double temp = ceil % 3;
                ceil = temp == 0.0 ? 3 : temp;
            }
            String s = String.valueOf(ceil);
            return s.substring(0, s.length() - 2);
        } catch (ParseException e) {
            logger.error("ParseException partitionkey_day_3 date" + e);
        } catch (Exception e) {
            logger.error("Exception partitionkey_day_3 date" + e);
        }
        return "";
    }

    // 日400分区  ${partitionkey_day_400}
    private static String get400Partition(Date cronTime) {
        try {
            Date parse = Y_M_D_FORMAT.parse(BEGIN_DATE);
            long abs = Math.abs(cronTime.getTime() - parse.getTime() );
            double ceil = Math.ceil(abs / (1000 * 3600 * 24));
            if (ceil > 400) {
                double temp = ceil % 400;
                ceil = temp == 0.0 ? 400 : temp;
            }
            String s = String.valueOf(ceil);
            return s.substring(0, s.length() - 2);
        } catch (ParseException e) {
            logger.error("ParseException partitionkey_day_400 date" + e);
        } catch (Exception e) {
            logger.error("Exception partitionkey_day_400 date" + e);
        }
        return "";
    }

    // 日400分区，最前面补0 ${partitionkey_day_400_cc}
    private static String getPartitionkeyDay400CC(Date cronTime) {
        try {
            String partition = get400Partition(cronTime);
            if (partition.length() >= 2 && partition.length() < 3) {
                return ZERO + partition;
            } else if (partition.length() > 0 && partition.length() < 2) {
                return ZEROCC + partition;
            }
            return partition;
        } catch (Exception e) {
            logger.error("Error partitionkey_day_400_cc date" + e);
        }
        return "";
    }

    // 日36分区，最前面补0   ${partitionkey_day_36_cc}  时间偏移是T-1
    private static String getPartitionkeyDay36CC(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.DAY_OF_MONTH, parseCalender.get(Calendar.DAY_OF_MONTH) - 1);
            Date beginDate = Y_M_D_FORMAT.parse(BEGIN_DATE);
            long abs = Math.abs(parseCalender.getTime().getTime() - beginDate.getTime());
            double ceil = Math.ceil(abs / (1000 * 3600 * 24));// 天数
            if (ceil > 36) {
                double temp = ceil % 36;
                ceil = temp == 0.0 ? 36 : temp;
            }
            String s = String.valueOf(ceil);
            String s2 = s.substring(0, s.length() - 2);
            if (s2.length() > 0 && s2.length() < 2) {
                return ZERO + s2;
            }
            return s2;
        } catch (ParseException e) {
            logger.error("ParseException partitionkey_day_36_cc date" + e);
        } catch (Exception e) {
            logger.error("Exception partitionkey_day_36_cc date" + e);
        }
        return "";
    }

    // 下一天日36分区  ${next_partitionkey_day_36}   时间偏移是T-1
    private static String getNextDay36Partition(Date cronTime) {
        try {
            Date beginDate = Y_M_D_FORMAT.parse(BEGIN_DATE);
            long abs = Math.abs(cronTime.getTime() - beginDate.getTime());
            double ceil = Math.ceil(abs / (1000 * 3600 * 24));// 天数
            if (ceil > 36) {
                double temp = ceil % 36;
                ceil = temp == 0.0 ? 36 : temp;
            }
            String s = String.valueOf(ceil);
            return s.substring(0, s.length() - 2);
        } catch (Exception e) {
            logger.error("Exception next_partitionkey_day_36 date" + e);
        }
        return "";
    }

    // 下一天日36分区，最前面补0  ${next_partitionkey_day_36_cc}   时间偏移是T-1
    private static String getNextPartitionkeyDay36CC(Date cronTime) {
        try {
            String nextDay36Partition = getNextDay36Partition(cronTime);
            if (nextDay36Partition.length() > 0 && nextDay36Partition.length() < 2) {
                return ZERO + nextDay36Partition;
            }
            return nextDay36Partition;
        } catch (Exception e) {
            logger.error("Exception next_partitionkey_day_36_cc date" + e);
        }
        return "";
    }

    // 日90分区   ${partitionkey_day_90} 时间偏移是T-1
    private static String get90DayPartition(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.DAY_OF_MONTH, parseCalender.get(Calendar.DAY_OF_MONTH) - 1);
            Date beginDate = Y_M_D_FORMAT.parse(BEGIN_DATE);
            long abs = Math.abs(parseCalender.getTime().getTime() - beginDate.getTime());
            double ceil = Math.ceil(abs / (1000 * 3600 * 24));// 天数
            if (ceil > 90) {
                double temp = ceil % 90;
                ceil = temp == 0.0 ? 90 : temp;
            }
            String s = String.valueOf(ceil);
            return s.substring(0, s.length() - 2);
        } catch (Exception e) {
            logger.error("Exception partitionkey_day_90 date" + e);
        }
        return "";
    }

    // 日90分区，最前面补0  ${partitionkey_day_90_cc}   时间偏移是T-1
    private static String getPartitionkeyDay90CC(Date cronTime) {
        try {
            String nextDay90Partition = get90DayPartition(cronTime);
            if (nextDay90Partition.length() > 0 && nextDay90Partition.length() < 2) {
                return ZERO + nextDay90Partition;
            }
            return nextDay90Partition;
        } catch (Exception e) {
            logger.error("Exception partitionkey_day_90_cc date" + e);
        }
        return "";
    }

    // 日星期几  ${week_num}   时间偏移是T-1
    private static String getWeekNum(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.DAY_OF_MONTH, parseCalender.get(Calendar.DAY_OF_MONTH) - 1);
            int i = parseCalender.get(Calendar.DAY_OF_WEEK) - 1;
            if (i == 0 ) {
                i = 7;
            }
            return String.valueOf(i);
        } catch (Exception e) {
            logger.error("Exception week_num date" + e);
        }
        return "";
    }

    // 本月最后一天 ${last_date} T-1
    private static String getLastDayofMoth(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            Date lastDayOfMonth = DateUtils.getLastDayOfMonth(calendar.getTime());
            return getDayDateD(lastDayOfMonth);
        } catch (Exception e) {
            logger.error("Exception last_date date" + e);
        }
        return "";
    }

    // 本月天数 ${last_day_number}  T-1
    private static String getLastDayNumber(Date cronTime) {
        try {
            return getLastDayofMoth(cronTime);
        } catch (Exception e) {
            logger.error("Exception last_day_number date" + e);
        }
        return "";
    }

    // 上月最后一天 ${per_last_date}
    private static String getLastDayofPreMoth(Date cronTime) {
        try {
            Date lastDayOfMonth = DateUtils.getLastDayOfMonth(DateUtils.addMonths(cronTime, -1));
            return getDayDateD(lastDayOfMonth);
        } catch (Exception e) {
            logger.error("Exception per_last_date date" + e);
        }
        return "";
    }

    // 上月天数 ${pre_last_day_number}
    private static String getPreLastDayNumber(Date cronTime) {
        try {
            return getLastDayofPreMoth(cronTime);
        } catch (Exception e) {
            logger.error("Exception pre_last_day_number date" + e);
        }
        return "";
    }

    // 12月分区   ${mon_number12}   时间偏移是T-1
    private static String getMonNumber12(Date cronTime) {
        try {
            Date lastMonth = DateUtils.getLastDayOfMonth(DateUtils.addMonths(cronTime, -1));
            return getMonthDateM(lastMonth);
        } catch (Exception e) {
            logger.error("Exception mon_number12 date" + e);
        }
        return "";
    }

    // 12月分区，最前面补0    ${mon_number12_cc}    时间偏移是T-1
    private static String getMonNumber12CC(Date cronTime) {
        try {
            Date lastMonth = DateUtils.getLastDayOfMonth(DateUtils.addMonths(cronTime, -1));
            return getMonthDateMM(lastMonth);
        } catch (Exception e) {
            logger.error("Exception mon_number12_cc date" + e);
        }
        return "";
    }

    // 下一天12月分区   ${next_mon_number12}  时间偏移是T-1
    private static String getNextMonNumber12(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.DAY_OF_MONTH, parseCalender.get(Calendar.DAY_OF_MONTH) + 1);

            Date lastMonth = DateUtils.addMonths(parseCalender.getTime(), -1);
            return getMonthDateM(lastMonth);
        } catch (Exception e) {
            logger.error("Exception next_mon_number12 date" + e);
        }
        return "";
    }

    // 下一天12月分区  ${${next_mon_number12_cc}}   时间偏移是T-1
    private static String getNextMonNumber12CC(Date cronTime) {
        try {
            String nextMonNumber12 = getNextMonNumber12(cronTime);
            if (nextMonNumber12.length() == 1) {
                return "0"+nextMonNumber12;
            }
            return nextMonNumber12;
        } catch (Exception e) {
            logger.error("Exception next_mon_number12_cc date" + e);
        }
        return "";
    }

    // 上月的月份 ${pre_mon_number12}   时间偏移是T-1
    private static String getPreMonNumber12(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.MONTH, parseCalender.get(Calendar.MONTH) - 2);
            return M_FORMAT.format(parseCalender.getTime());
        } catch (Exception e) {
            logger.error("Error pre_mon_number12 date" + e);
        }
        return "";
    }

    // 上月的月份，最前面补0  ${pre_mon_number12_cc}  时间偏移是T-1
    private static String getPreMonNumber12CC(Date cronTime) {
        try {
            String preMonNumber12 = getPreMonNumber12(cronTime);
            if (1 == preMonNumber12.length()) {
                return "0" + preMonNumber12;
            }
            return preMonNumber12;
        } catch (Exception e) {
            logger.error("Error pre_mon_number12_cc date" + e);
        }
        return "";
    }

    // 上月的奇偶年 ${pre_mon_double_year}
    private static String getPreMonDoubleYear(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.MONTH, parseCalender.get(Calendar.MONTH) - 1);
            Integer yearDateYYYY = Integer.valueOf(getYearDateYYYY(parseCalender.getTime()));
            return yearDateYYYY % 2 == 0 ? "2" : "1";
        } catch (Exception e) {
            logger.error("Error pre_mon_double_year date" + e);
        }
        return "";
    }

    // 月7分区 ${partitionkey_mon_7}  时间偏移是T-1
    private static String getPartitionkeyMon7(Date cronTime) {
        try {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(Y_M_D_FORMAT.parse(BEGIN_DATE));
            end.setTime(cronTime);
            end.set(Calendar.MONTH, end.get(Calendar.MONTH) - 1);
            int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
            int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
            int all = result + month;
            if (all > 7) {
                int temp = all % 7;
                all = temp == 0 ? 7 : temp;
            }
            String s = String.valueOf(all);
            return s;
        }catch (ParseException e) {
            logger.error("ParseException partitionkey_mon_7 date" + e);
        } catch (Exception e) {
            logger.error("Exception partitionkey_mon_7 date" + e);
        }
        return "";
    }

    // 上月25分区 ${partitionkey_mon_25_pre}  时间偏移是T-1
    private static String getPartitionkeyMon25Pre(Date cronTime) {
        try {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(Y_M_D_FORMAT.parse(BEGIN_DATE));
            end.setTime(cronTime);
            end.set(Calendar.MONTH, end.get(Calendar.MONTH) - 2);
            int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
            int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
            int all = result + month;
            if (all > 25) {
                int temp = all % 25;
                all = temp == 0 ? 25 : temp;
            }
            String s = String.valueOf(all);
            return s;
        }catch (ParseException e) {
            logger.error("ParseException partitionkey_mon_25_pre date" + e);
        } catch (Exception e) {
            logger.error("Exception partitionkey_mon_25_pre date" + e);
        }
        return "";
    }

    // 上月25分区，最前面补0 ${partitionkey_mon_25_cc_pre}  时间偏移是T-1
    private static String getPartitionkeyMon25CCPre(Date cronTime) {
        try {
            String partitionkeyMon25Pre = getPartitionkeyMon25Pre(cronTime);
            if (partitionkeyMon25Pre.length() == 1) {
                return ZERO + partitionkeyMon25Pre;
            }
            return partitionkeyMon25Pre;
        } catch (Exception e) {
            logger.error("Exception partitionkey_mon_25_cc_pre date" + e);
        }
        return "";
    }

    // 上一天day_number ${pre_day_number}  时间偏移是T-1
    private static String getPreDayNumber(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 2);
            return getDayDateDD(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception pre_day_number date" + e);
        }
        return "";
    }

    // 上一天日期 ${pre_date}  时间偏移是T-1
    private static String getPreDate(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 2);
            return Y_M_D_FORMAT.format(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception pre_date date" + e);
        }
        return "";
    }


    // 前一天的奇偶月，${pre_double_month_d}  时间偏移是T-1
    private static String getPreDoubleMonthD(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.DAY_OF_MONTH, parseCalender.get(Calendar.DAY_OF_MONTH) - 1);
            return getDoubleMonth(parseCalender.getTime());
        } catch (Exception e) {
            logger.error("Error pre_double_month_d date" + e);
        }
        return "";
    }

    // 前一天的奇偶月，最前面补0，最前面补0  ${pre_double_month}   时间偏移是T-1
    private static String getPreDoubleMonth(Date cronTime) {
        try {
            return ZERO + getPreDoubleMonthD(cronTime);
        } catch (Exception e) {
            logger.error("Error pre_double_month date" + e);
        }
        return "";
    }

    // 月3分区 ${partitionkey_mon_3}  时间偏移是T-1
    private static String getPartitionKeyMon3(Date cronTime) {
        try {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(Y_M_D_FORMAT.parse(BEGIN_DATE));
            end.setTime(cronTime);
            end.set(Calendar.MONTH, end.get(Calendar.MONTH) - 1);
            int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
            int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
            int all = result + month;
            if (all > 3) {
                int temp = all % 3;
                all = temp == 0 ? 3 : temp;
            }
            String s = String.valueOf(all);
            return s;
        }catch (ParseException e) {
            logger.error("ParseException partitionkey_mon_3 date" + e);
        }
        catch (Exception e) {
            logger.error("Exception partitionkey_mon_3 date" + e);
        }
        return "";
    }

    // 3月,格式01/02/03(1月为01) ${three_month}  时间偏移是T-1
    private static String getThreeMonth(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);

            int all = calendar.get(Calendar.MONTH);
            if (all > 3) {
                int temp = all % 3;
                all = temp == 0 ? 3 : temp;
            }
            all = all == 0 ? 3 : all;
            String s = String.valueOf(all);
            return ZERO + s;
        } catch (Exception e) {
            logger.error("Exception partitionkey_mon_3 date" + e);
        }
        return "";
    }

    // 上月的奇偶年 ${pre_double_year}  T-1
    private static String getPreDoubleYear(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.MONTH, parseCalender.get(Calendar.MONTH) - 1);
            return getJustParityYear(parseCalender.getTime());
        } catch (Exception e) {
            logger.error("Error pre_double_year date" + e);
        }
        return "";
    }

    // 月份 ${stat_month}  时间偏移是T-1
    private static String getStatMonth(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.MONTH, parseCalender.get(Calendar.MONTH) - 1);
            return Y_M_FORMAT.format(parseCalender.getTime());
        } catch (Exception e) {
            logger.error("Error stat_month date" + e);
        }
        return "";
    }

    // 月25分区 ${partitionkey_mon_25}  时间偏移是T-1
    private static String getPartitionKeyMon25(Date cronTime) {
        try {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(Y_M_D_FORMAT.parse(BEGIN_DATE));
            end.setTime(cronTime);
            end.set(Calendar.MONTH, end.get(Calendar.MONTH) - 1);
            int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
            int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
            int all = result + month;
            if (all > 25) {
                int temp = all % 25;
                all = temp == 0 ? 25 : temp;
            }
            String s = String.valueOf(all);
            return s;
        }catch (ParseException e) {
            logger.error("ParseException partitionkey_mon_25 date" + e);
        }catch (Exception e) {
            logger.error("Exception partitionkey_mon_25 date" + e);
        }
        return "";
    }

    // 月25分区，最前面补0 ${partitionkey_mon_25_cc}  时间偏移是T-1
    private static String getPartitionKeyMon25CC(Date cronTime) {
        try {
            String partitionKeyMon25 = getPartitionKeyMon25(cronTime);
            if (partitionKeyMon25.length() == 1) {
                partitionKeyMon25 = ZERO + partitionKeyMon25;
            }
            return partitionKeyMon25;
        } catch (Exception e) {
            logger.error("Exception partitionkey_mon_25_cc date" + e);
        }
        return "";
    }

    // five Base
    private static String getFiveYearBase(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
            String format = Y_M_FORMAT.format(calendar.getTime());
            Integer integer = Integer.valueOf(format);

            int temp = integer % 5;
            integer = temp == 0 ? 5 : temp;
            String s = String.valueOf(integer);
            return "0" + s;
        } catch (Exception e) {
            logger.error("Exception five_year_base date" + e);
        }
        return "";
    }

    // 5年,格式01/02/03/04/05 ${five_year} 时间偏移是T-1

    /**
     * 当前是2023年2月，即202302除以5，除净则为5，反之取余数，即202302除以5余3则，取03。2024年则取04,2025则取05,2026取01.。。
     */
    private static String getFiveYear(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);// T-1
            return getFiveYearBase(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception five_year date" + e);
        }
        return "";
    }

    // 本月中前一天日期  ${pre_day_inmonth} 时间偏移是T-1
    private static String getPreDayInmonth(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 2);
            return Y_M_D_FORMAT.format(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception pre_day_inmonth date" + e);
        }
        return "";
    }

    // 上一年五年分表，格式01/02/03/04/05 ${v_five_year_preY} 时间偏移是T-1
    private static String getVFiveYearPreY(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);

            return getFiveYear(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_five_year_preY date" + e);
        }
        return "";
    }

    // 月变量60个月分区补0 ${v_partition_key_60_cc}}  时间偏移是T-1
    private static String getVPartitionKey60CC(Date cronTime) {
        try {
            String vPartitionKey60 = getVPartitionKey60(cronTime);
            if (vPartitionKey60.length() == 1) {
                vPartitionKey60 = ZERO + vPartitionKey60;
            }
            return vPartitionKey60;
        } catch (Exception e) {
            logger.error("Exception v_partition_key_60_cc date" + e);
        }
        return "";
    }

    // 上个月60分区cc ${v_partition_key_60_pre1_cc}  时间偏移是T-1
    private static String getVPartitionKey60Pre1CC(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            return getVPartitionKey60CC(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_partition_key_60_pre1_cc date" + e);
        }
        return "";
    }

    // 日：上月上一年五年分表，格式01/02/03/04/05 ${v_last_year_five} 时间偏移是T-1
    private static String getVLastYearFive(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);// T-1
            return getFiveYearBase(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_last_year_five date" + e);
        }
        return "";
    }

    // 三个月前五年分区，${v_five_year_pre3} 时间偏移是T-1
    private static String getVFiveYearPre3(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 3);
            return getFiveYear(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_five_year_pre3 date" + e);
        }
        return "";
    }

    // 日变量，统计日期四百天之前的日期   ${v_pre_day400_date} 时间偏移是T-1
    private static String getVPreDay400Date(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 401);
            return Y_M_D_FORMAT.format(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_pre_day400_date date" + e);
        }
        return "";
    }

    // 月变量，取统计月份五年前的月份   ${v_pre_mon60_mon} 时间偏移是T-1
    private static String getVPreMon60Mon(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);// T-1
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-5);
            return Y_M_FORMAT.format(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_pre_mon60_mon date" + e);
        }
        return "";
    }

    // 日变量 取去年同期（日）  ${v_pre_year_day}  时间偏移是T-1
    private static String getVPreYearDay(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);// T-1
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
            return Y_M_D_FORMAT.format(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_pre_year_day date" + e);
        }
        return "";
    }

    // 月变量 取去年同期（月）  ${v_pre_year_mon}  时间偏移是T-1
    private static String getVPreYearMon(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);// T-1
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
            return Y_M_FORMAT.format(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_pre_year_mon date" + e);
        }
        return "";
    }

    // 上上个月  ${pre2_mon_year_number}  时间偏移是T-1
    private static String getPre2MonYearNumber(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 3);// T-1
            return Y_M_FORMAT.format(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception pre2_mon_year_number date" + e);
        }
        return "";
    }

    // 上一个月,YYYYMM ${pre1_mon_year_number}  时间偏移是T-1
    private static String getPre1MonYearNumber(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 2);// T-1
            return Y_M_FORMAT.format(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception pre1_mon_year_number date" + e);
        }
        return "";
    }

    // 上个月，三月分区 ${pre_three_month}  时间偏移是T-1
    private static String getPreThreeMonth(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            return getThreeMonth(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception pre_three_month date" + e);
        }
        return "";
    }

    // 月120分区 ${partitionkey_mon_120}  时间偏移是T-1
    private static String getPartitionkeyMon120(Date cronTime) {
        try {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(Y_M_D_FORMAT.parse(BEGIN_DATE));
            end.setTime(cronTime);
            end.set(Calendar.MONTH, end.get(Calendar.MONTH) - 1);
            int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
            int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
            int all = result + month;
            if (all > 120) {
                int temp = all % 120;
                all = temp == 0 ? 120 : temp;
            }
            String s = String.valueOf(all);
            return s;
        }catch (ParseException e) {
            logger.error("ParseException partitionkey_mon_120 date" + e);
        }catch (Exception e) {
            logger.error("Exception partitionkey_mon_120 date" + e);
        }
        return "";
    }

    // 月120分区,最前面补0  ${partitionkey_mon_120_cc}  时间偏移是T-1
    private static String getPartitionkeyMon120CC(Date cronTime) {
        try {
            String partitionkeyMon120 = getPartitionkeyMon120(cronTime);
            if (partitionkeyMon120.length() == 1) {
                return ZEROCC + partitionkeyMon120;
            } else if (partitionkeyMon120.length() == 2) {
                return ZERO + partitionkeyMon120;
            }
            return partitionkeyMon120;
        } catch (Exception e) {
            logger.error("Exception partitionkey_mon_120_cc date" + e);
        }
        return "";
    }

    // 日：上一日400分区  ${pre_day_400} 时间偏移是T-1
    private static String getPreDay400(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 2);
            return get400Partition(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception pre_day_400 date" + e);
        }
        return "";
    }

    // 日对应上一年  ${v_last_year}   时间偏移是T-1
    private static String getVLastYear(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);// T-1
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-1);
            return getYearDateYYYY(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception pre_day_400 date" + e);
        }
        return "";
    }

    // 月变量60个月分区 ${v_partition_key_60} 时间偏移是T-1
    private static String getVPartitionKey60(Date cronTime) {
        try {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(Y_M_D_FORMAT.parse(BEGIN_DATE));
            end.setTime(cronTime);
            end.set(Calendar.MONTH, end.get(Calendar.MONTH) - 1);// T-1
            int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
            int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
            int all = result + month;
            if (all > 60) {
                int temp = all % 60;
                all = temp == 0 ? 60 : temp;
            }
            String s = String.valueOf(all);
            return s;
        }catch (ParseException e) {
            logger.error("ParseException v_partition_key_60 date" + e);
        }catch (Exception e) {
            logger.error("Exception v_partition_key_60 date" + e);
        }
        return "";
    }

    // 月变量 上一个月对应的60分区 ${v_partition_key_60_pre1} 时间偏移是T-1
    private static String getVPartitionKey60Pre1(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);// T-1
            return getVPartitionKey60(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_partition_key_60_pre1 date" + e);
        }
        return "";
    }

    // 月上一月对应5年分表 ${v_five_year_pre1} 时间偏移是T-1
    private static String getVFiveYearPre1(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            return getFiveYear(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_five_year_pre1 date" + e);
        }
        return "";
    }

    // 月上两月对应5年分表 ${v_five_year_pre2} 时间偏移是T-1
    private static String getVFiveYearPre2(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 2);
            return getFiveYear(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_five_year_pre2 date" + e);
        }
        return "";
    }

    // 月下月 ${v_next_month}  时间偏移是T-1
    private static String getVNextMonth(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
            return Y_M_FORMAT.format(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_next_month date" + e);
        }
        return "";
    }

    // 月：下月五年分区  ${v_five_year_next1}  时间偏移是T-1
    private static String getVFiveYearNext1(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
            return getFiveYear(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_five_year_next1 date" + e);
        }
        return "";
    }

    // 年：前年对应的五年分区  ${v_five_year_preY2}  时间偏移是T-1
    private static String getVFiveYearPreY2(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 3);
            return getFiveYearBase(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_five_year_preY2 date" + e);
        }
        return "";
    }

    // 月：下月MM  ${next1_mon_number12_cc}  时间偏移是T-1
    private static String getNext1MonNumBer12CC(Date cronTime) {
        try {
            return getDayDateDD(cronTime);
        } catch (Exception e) {
            logger.error("Exception next1_mon_number12_cc date" + e);
        }
        return "";
    }

    // 月：下下月MM  ${next2_mon_number12_cc} 时间偏移是T-1
    private static String getNext2MonNumBer12CC(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
            return getDayDateDD(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception next2_mon_number12_cc date" + e);
        }
        return "";
    }

    // 月：下月YYYYMM  ${next1_mon_year_number}  时间偏移是T-1
    private static String getNext1MonYearNumber(Date cronTime) {
        try {
            return Y_M_FORMAT.format(cronTime);
        } catch (Exception e) {
            logger.error("Exception next1_mon_year_number date" + e);
        }
        return "";
    }

    // 月：下下月YYYYMM  ${next2_mon_year_number}  时间偏移是T-1
    private static String getNext2MonYearNumber(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
            return Y_M_FORMAT.format(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception next2_mon_year_number date" + e);
        }
        return "";
    }

    // 上一天所在月对应的3分区，取2位 $[pre_day_three_month]  时间偏移是T-1
    private static String getPreDayThreeMonth(Date cronTime) {
        try {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(Y_M_D_FORMAT.parse(BEGIN_DATE));
            end.setTime(cronTime);
            end.set(Calendar.DAY_OF_MONTH, end.get(Calendar.DAY_OF_MONTH) - 1);
            end.set(Calendar.MONTH, end.get(Calendar.MONTH) - 1);// T-1
            int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
            int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
            int all = result + month;
            if (all > 3) {
                int temp = all % 3;
                all = temp == 0 ? 3 : temp;
            }
            String s = String.valueOf(all);
            return ZERO+s;
        } catch (ParseException e) {
            logger.error("ParseException pre_day_three_month date" + e);
        } catch (Exception e) {
            logger.error("Exception pre_day_three_month date" + e);
        }
        return "";
    }

    // 当前日前一天对应的月，$[pre_day_mon_number12]  时间偏移是T-1
    private static String getPreDayMonNumber12(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)-1);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);// T-1
            return getMonthDateMM(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception next2_mon_year_number date" + e);
        }
        return "";
    }

    // 日变量:40分区  ${partitionkey_day_40_cc}  时间偏移是T-1
    private static String getPartitionKeyDay40CC(Date cronTime) {
        try {
            Calendar parseCalender = Calendar.getInstance();
            parseCalender.setTime(cronTime);
            parseCalender.set(Calendar.DAY_OF_MONTH, parseCalender.get(Calendar.DAY_OF_MONTH) - 1);
            Date beginDate = Y_M_D_FORMAT.parse(BEGIN_DATE);
            long abs = Math.abs(parseCalender.getTime().getTime() - beginDate.getTime());
            double ceil = Math.ceil(abs / (1000 * 3600 * 24));
            if (ceil > 40) {
                double temp = ceil % 40;
                ceil = temp == 0.0 ? 3 : temp;
            }
            String s = String.valueOf(ceil);
            String substring = s.substring(0, s.length() - 2);
            return substring.length() == 1 ? ZERO+substring : substring;
        } catch (ParseException e) {
            logger.error("ParseException partitionkey_day_40_cc date" + e);
        } catch (Exception e) {
            logger.error("Exception partitionkey_day_40_cc date" + e);
        }
        return "";
    }

    // 日变量：当前日对应的上一周三月分表 ${pre_three_month_7} 时间偏移是T-1
    private static String getPreThreeMonth7(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 8);
            int all = calendar.get(Calendar.MONTH);
            if (all > 3) {
                int temp = all % 3;
                all = temp == 0 ? 3 : temp;
            }
            String s = String.valueOf(all);
            return ZERO + s;
        } catch (Exception e) {
            logger.error("Exception pre_three_month_7 date" + e);
        }
        return "";
    }

    // 日变量：当前日对应的上一周400分区 ${partitionkey_day_400_7}
    private static String getPartitionKeyDay4007(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 7);
            return get400Partition(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception partitionkey_day_400_7 date" + e);
        }
        return "";
    }

    // 日变量：当前日对应的上一月同期400分区 ${partitionkey_month_400}
    private static String getPartitionKeyMonth400(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            return get400Partition(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception partitionkey_month_400 date" + e);
        }
        return "";
    }

    // 月变量：当前月对应的上一年同期的60分区 ${v_partition_key_60_pre12}
    private static String getVPartitionKey60Pre12(Date cronTime) {
        try {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(Y_M_D_FORMAT.parse(BEGIN_DATE));
            end.setTime(cronTime);
            end.set(Calendar.YEAR, end.get(Calendar.YEAR) - 1);
            int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
            int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
            int all = result + month;
            if (all > 60) {
                int temp = all % 60;
                all = temp == 0 ? 60 : temp;
            }
            String s = String.valueOf(all);
            return s;
        } catch (Exception e) {
            logger.error("Exception v_partition_key_60_pre12 date" + e);
        }
        return "";
    }

    // 月变量：上上月对应的60分区   ${v_partition_key_60_pre2}
    private static String getVPartitionKey60Pre2(Date cronTime) {
        try {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(Y_M_D_FORMAT.parse(BEGIN_DATE));
            end.setTime(cronTime);
            end.set(Calendar.MONTH, end.get(Calendar.MONTH) - 2);
            int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
            int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
            int all = result + month;
            if (all > 60) {
                int temp = all % 60;
                all = temp == 0 ? 60 : temp;
            }
            return String.valueOf(all);
        } catch (ParseException e) {
            logger.error("ParseException v_partition_key_60_pre2 date" + e);
        } catch (Exception e) {
            logger.error("Exception v_partition_key_60_pre2 date" + e);
        }
        return "";
    }

    // 月变量：上一年最后一个月对应的60分区      ${pre_year_partition_key_60_mon}
    private static String getPreYearPartitionKey60Mon(Date cronTime) {
        try {
            // 获取上一年最后一个月
            String pre1MonYearNumber12 = getPre1MonYearNumber12(cronTime);
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(Y_M_D_FORMAT.parse(BEGIN_DATE));
            Date parse = Y_M_FORMAT.parse(pre1MonYearNumber12);
            end.setTime(parse);
            int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
            int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
            int all = result + month;
            if (all > 60) {
                int temp = all % 60;
                all = temp == 0 ? 60 : temp;
            }
            return String.valueOf(all);
        }catch (ParseException e) {
            logger.error("ParseException pre_year_partition_key_60_mon date" + e);
        } catch (Exception e) {
            logger.error("Exception pre_year_partition_key_60_mon date" + e);
        }
        return "";
    }

    // 月变量：上一年最后一个月      ${pre1_mon_year_number12}
    private static String getPre1MonYearNumber12(Date cronTime) {
        try {
            Calendar end = Calendar.getInstance();
            end.setTime(cronTime);
            end.set(Calendar.YEAR, end.get(Calendar.YEAR)-1);
            String yearDateYYYY = getYearDateYYYY(end.getTime());
            return yearDateYYYY + "12";
        } catch (Exception e) {
            logger.error("Exception pre1_mon_year_number12 date" + e);
        }
        return "";
    }

    // 日变量：上一年最后一天     $[pre_year_last_date]
    private static String getPreYearLastDate(Date cronTime) {
        try {
            String pre1MonYearNumber12 = getPre1MonYearNumber12(cronTime);// 上一年最后一个月
            Date date = Y_M_FORMAT.parse(pre1MonYearNumber12);
            Date lastDayOfMonth = DateUtils.getLastDayOfMonth(date);// 最后一个月的最后一天
            return Y_M_D_FORMAT.format(lastDayOfMonth);
        } catch (Exception e) {
            logger.error("Exception pre_year_last_date date" + e);
        }
        return "";
    }

    // 日变量：当前日对应上一年同期的400分区    ${partitionkey_year_400}
    private static String getPartitionKeyYear400(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-1);
            return get400Partition(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception partitionkey_year_400 date" + e);
        }
        return "";
    }

    // 当前月12月分区   ${curr_mon_number12}
    private static String get12MoenthPartition(Date cronTime,int T) {

        try {
            Date lastMonth = DateUtils.getLastDayOfMonth(DateUtils.addMonths(cronTime, T));
            return getMonthDateM(lastMonth);
        } catch (Exception e) {
            logger.error("Exception curr_mon_number12 date" + e);
        }
        return "";
    }

    // 月变量：上1个月对应的12分区   ${pre1_mon_number12_cc}
    private static String getPre1MonNumber12CC(Date cronTime) {
        try {
            return get12MoenthPartition(cronTime,-1);
        } catch (Exception e) {
            logger.error("Exception pre1_mon_number12_cc date" + e);
        }
        return "";
    }

    // 月变量：上2个月对应的12分区   ${pre2_mon_number12_cc}
    private static String getPre2MonNumber12CC(Date cronTime) {
        try {
            return get12MoenthPartition(cronTime,-2);
        } catch (Exception e) {
            logger.error("Exception pre2_mon_number12_cc date" + e);
        }
        return "";
    }

    // 月变量：上3个月对应的12分区  ${pre3_mon_number12_cc}
    private static String getPre3MonNumber12CC(Date cronTime) {
        try {
            return get12MoenthPartition(cronTime,-3);
        } catch (Exception e) {
            logger.error("Exception pre3_mon_number12_cc date" + e);
        }
        return "";
    }

    // 月变量：上4个月对应的12分区 ${pre4_mon_number12_cc}
    private static String getPre4MonNumber12CC(Date cronTime) {
        try {
            return get12MoenthPartition(cronTime,-4);
        } catch (Exception e) {
            logger.error("Exception pre4_mon_number12_cc date" + e);
        }
        return "";
    }

    // 月变量：上5个月对应的12分区 ${pre5_mon_number12_cc}
    private static String getPre5MonNumber12CC(Date cronTime) {
        try {
            return get12MoenthPartition(cronTime,-5);
        } catch (Exception e) {
            logger.error("Exception pre5_mon_number12_cc date" + e);
        }
        return "";
    }

    // 月变量：上4个月对应的五年分表 ${v_five_year_pre4}
    private static String getVFiveYearPre4(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-4);
            return  getFiveYearBase(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_five_year_pre4 date" + e);
        }
        return "";
    }

    // 月变量：上5个月对应的五年分表 ${v_five_year_pre5}
    private static String getVFiveYearPre5(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-5);
            return  getFiveYearBase(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_five_year_pre5 date" + e);
        }
        return "";
    }

    // 月变量：上6个月对应的五年分表 ${v_five_year_pre6}
    private static String getVFiveYearPre6(Date cronTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cronTime);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-6);
            return  getFiveYearBase(calendar.getTime());
        } catch (Exception e) {
            logger.error("Exception v_five_year_pre6 date" + e);
        }
        return "";
    }
}
