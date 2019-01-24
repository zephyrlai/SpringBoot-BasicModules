package cn.zephyr.utils;


import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * 类DateUtil.java的实现描述：时间日期处理工具。
 */

public class DateUtil extends DateUtils {
    private static Logger logger              = LoggerFactory.getLogger(DateUtil.class);

    public static String PATTERNSTR_YMD="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
    public static String PATTERNSTR_YM="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-((0[1-9])|(1[0-2])))";
    public static String PATTERNSTR_Y="([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})";
    public static String DateMode_1 = "yyyy-MM-dd";
    public static String DateMode_2 = "yyyy-MM-dd HH:mm";
    public static String DateMode_3 = "yyyyMMddHHmmssSSS";
    public static String DateMode_4 = "yyyy-MM-dd HH:mm:ss";
    public static String DateMode_5 = "HHmmssSS";
    public static String DateMode_6 = "yyyyMMdd";
    public static String DateMode_7 = "HHmmss";
    public static String DateMode_8 = "yyyy";
    public static String DateMode_9 = "yyyyMMddHHmmss";
    public static String DateMode_10 = "HH:mm:ss";
    public static String DateMode_11 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static String DateMode_12 = "yyyy/MM/dd";
    public static String DATE_REGEX          = "\\d{4}-\\d{1,2}-\\d{1,2}";
    public static String DEFAULT_DATE_FORMAT = DateMode_1;


    /**
     * Date转换为LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     * @param time
     * @return
     */
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取指定时间的指定格式
     * @param time
     * @param pattern
     * @return
     */
    public static String formatTime(LocalDateTime time,String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Date 转指定格式的时间字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String dateFormatTime(Date date,String pattern){
        return convertDateToLDT(date).format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前时间的指定格式
     * @param pattern
     * @return
     */
    public static String formatNow(String pattern) {
        return  formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * 日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
     * @param time
     * @param number
     * @param field
     * @return
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    /**
     * 日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
     * @param time
     * @param number
     * @param field
     * @return
     */
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field){
        return time.minus(number,field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     * @param startTime
     * @param endTime
     * @param field  单位(年月日时分秒)
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    /**
     * 获取一天的开始时间，2017,7,22 00:00
     * @param time
     * @return
     */
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    /**
     * 获取一天的结束时间
     * @param time
     * @return
     */
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }

    public static Date stringToDate(String date) {
        SimpleDateFormat sdf=new SimpleDateFormat(DateMode_1);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date stringToDate(String date,String pattern) {
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取当前日期是星期几<br>
     *
     * @param date
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date date) {
        if (date!=null){
            String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0){
                w = 0;
            }
            return weekDays[w];
        }else{
            return null;
        }

    }

}

