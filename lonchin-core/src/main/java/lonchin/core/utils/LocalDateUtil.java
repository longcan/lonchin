package lonchin.core.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间格式化工具类
 *
 * @author: chenlc
 * @date: 2021/4/15
 * @version: V1.0
 */
public class LocalDateUtil {

    public static final String HH_MM = "HH:mm";
    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String YYYYMM = "yyyyMM";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String TIME_ZONE = "GMT+8";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    /**
     * 功能描述: 获取当前日期时间
     * @author chenlc
     * @date 2021/4/20
     * @param
     * @return java.lang.String
     */
    public static String currentDateTime(){
        return dateTimeToFullStr(LocalDateTime.now());
    }

    /**
     * 功能描述: 获取当前日期
     * @author chenlc
     * @date 2021/4/20
     * @param
     * @return java.lang.String
     */
    public static String currentDate(){
        return dateToStr(LocalDate.now());
    }

    /**
     * 功能描述: 格式化时间
     * @author chenlc
     * @date 2020/12/30
     * @param dateTime
     * @param pattern
     * @return java.lang.String
     */
    public static String dateTimeToStr (LocalDateTime dateTime, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(dateTime);
    }

    /**
     * 功能描述: 格式化时间（YYYY_MM_DD_HH_MM_SS）
     * @author chenlc
     * @date 2020/12/30
     * @param dateTime
     * @return java.lang.String
     */
    public static String dateTimeToFullStr (LocalDateTime dateTime) {
        return dateTimeToStr(dateTime, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 功能描述: 格式化时间（YYYY_MM_DD）
     * @author chenlc
     * @date 2020/12/30
     * @param dateTime
     * @return java.lang.String
     */
    public static String dateTimeToStr (LocalDateTime dateTime) {
        return dateTimeToStr(dateTime, YYYY_MM_DD);
    }

    /**
     * 功能描述: 格式化时间
     * @author chenlc
     * @date 2020/12/30
     * @param date
     * @param pattern
     * @return java.lang.String
     */
    public static String dateToStr (LocalDate date, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(date);
    }

    /**
     * 功能描述: 格式化时间（YYYY_MM_DD_HH_MM_SS）TODO
     * @author chenlc
     * @date 2020/12/30
     * @param date
     * @return java.lang.String
     */
    public static String dateToFullStr (LocalDate date) {
        return dateToStr(date, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 功能描述: 格式化时间（YYYY_MM_DD）
     * @author chenlc
     * @date 2020/12/30
     * @param date
     * @return java.lang.String
     */
    public static String dateToStr (LocalDate date) {
        return dateToStr(date, YYYY_MM_DD);
    }


    /**
     * 功能描述: 时间字符串转LocalDate
     * @author chenlc
     * @date 2021/1/12
     * @param date
     * @return java.time.LocalDate
     */
    public static LocalDate strToDate (String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(YYYY_MM_DD));
    }

    /**
     * 功能描述: 时间字符串转LocalDateTime
     * @author chenlc
     * @date 2021/1/12
     * @param datetime
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime strToDateTime (String datetime) {
        return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS));
    }

    /**
     * 功能描述: 获取某天的开始时间
     * @author chenlc
     * @date 2021/1/12
     * @param dateStr
     * @return java.time.LocalDateTime
     */
    public static String getStartTimeOfDay (String dateStr) {
        return dateStr + " 00:00:00";
    }

    /**
     * 功能描述: 获取某天的结束时间
     * @author chenlc
     * @date 2021/1/12
     * @param dateStr
     * @return java.util.String
     */
    public static String getEndTimeOfDay (String dateStr) {
        return dateStr + " 23:59:59";
    }

    /**
     * 功能描述: 获取某天的开始时间
     * @author chenlc
     * @date 2021/1/12
     * @param date
     * @return java.time.LocalDateTime
     */
    public static String getStartTimeOfDay (LocalDate date) {
        return getStartTimeOfDay(date.toString());
    }

    /**
     * 功能描述: 获取某天的结束时间
     * @author chenlc
     * @date 2021/1/12
     * @param date
     * @return java.util.String
     */
    public static String getEndTimeOfDay (LocalDate date) {
        return getEndTimeOfDay(date.toString());
    }

    /**
     * 功能描述: 获取某天的开始时间
     * @author chenlc
     * @date 2021/1/12
     * @param startTime
     * @return java.util.String
     */
    public static String getStartTimeOfDay (LocalDateTime startTime) {
        return getStartTimeOfDay(dateTimeToStr(startTime));
    }

    /**
     * 功能描述: 获取某天的结束时间
     * @author chenlc
     * @date 2021/1/12
     * @param endTime
     * @return java.time.LocalDateTime
     */
    public static String getEndTimeOfDay (LocalDateTime endTime) {
        return getEndTimeOfDay(dateTimeToStr(endTime));
    }

    /**
     * 功能描述: 计算两个日期之间的天数
     * @author chenlc
     * @date 2021/4/16
     * @param begin 开始时间
     * @param end 结束时间
     * @return long
     */
    public static long diffTwoDate (LocalDate begin, LocalDate end) {
        return end.toEpochDay() - begin.toEpochDay();
    }

    /**
     * 功能描述: 计算两个日期之间的天数
     * @author chenlc
     * @date 2021/4/16
     * @param begin 开始时间
     * @param end 结束时间
     * @return long
     */
    public static long diffTwoDate (String begin, String end) {
        return strToDate(end).toEpochDay() - strToDate(begin).toEpochDay();
    }

    /**
     * 功能描述: 计算两个日期之间的天数
     * @author chenlc
     * @date 2021/4/16
     * @param begin 开始时间
     * @param end 结束时间
     * @return long
     */
    public static long diffTwoDateTime (String begin, String end) {
        return strToDateTime(end).toLocalDate().toEpochDay() - strToDateTime(begin).toLocalDate().toEpochDay();
    }



    public static void main(String[] args) {
        System.out.println(strToDateTime("2021-04-16 07:48:46"));
    }

}
