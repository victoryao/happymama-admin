package com.happymama.admin.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Slf4j
public abstract class DateUtil {

    private static SimpleDateFormat intDateFormat = new SimpleDateFormat("yyyyMMdd");

    public static final String DATA_MINUTE_STRING = "yyyy-MM-dd HH:mm";

    public static final String DATA_STRING = "yyyy-MM-dd HH:mm:ss";

    /**
     * 当前日期转为字符串
     *
     * @param formate "yyyy-mm-dd hh:MM:ss"
     * @return String
     */
    public static String date2str(String formate) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat(formate);
        return sf.format(date);
    }

    public static String date2str() {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(date);
    }


    public static Date ln2date(long times) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(times * 1000);
        SimpleDateFormat format = new SimpleDateFormat(DATA_STRING);
        String strDate = format.format(gc.getTime());
        return DateUtil.strToDate(strDate);
    }

    public static String ln2Str(long times) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(times * 1000);
        SimpleDateFormat format = new SimpleDateFormat(DATA_STRING);
        String strDate = format.format(gc.getTime());
        return strDate;
    }


    /**
     * 入参是秒
     *
     * @param times
     * @return
     */
    public static String date2str(long times) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(times * 1000);
        SimpleDateFormat format = new SimpleDateFormat(DATA_STRING);
        return format.format(gc.getTime());
    }

    public static String date2shortStr(long times) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(times * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(gc.getTime());
    }

    public static String date2str(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sf = new SimpleDateFormat(DATA_STRING);
        return sf.format(date);
    }

    public static String date2shortStr(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(date);
    }

    public static String date2str(Date date, String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

    public static Date strToDate(String dateStr, String format) {
        SimpleDateFormat dd = new SimpleDateFormat(format);
        Date date = null;
        if (StringUtils.isNotEmpty(dateStr)) {
            try {
                date = dd.parse(dateStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public static Date shortStrToDate(String dateStr) {
        SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if (StringUtils.isNotEmpty(dateStr)) {
            try {
                date = dd.parse(dateStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public static Date strToDate(String dateStr) {
        SimpleDateFormat dd = new SimpleDateFormat(DATA_STRING);
        Date date = null;
        try {
            date = dd.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date strToShortDate(String dateStr) {
        SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dd.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 加日期
     *
     * @param dateStr
     * @param datetype Calendar.MONTH Calendar.YEAR ...
     * @param diff
     * @return
     */
    public static String addDate(String dateStr, int datetype, int diff) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateUtil.strToDate(dateStr));
        cal.add(datetype, diff);
        return sdf.format(cal.getTime());
    }

    public static String addDate(Date date, int datetype, int diff) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(datetype, diff);
        return sdf.format(cal.getTime());
    }

    /**
     * 格式化维服返回的格林威治日期
     * 如:2012-07-20T11: 39: 10.0000000+08: 00
     *
     * @param dateStr String
     * @return String
     */
    public static String wfDate2Str(String dateStr) {
        String result = StringUtils.EMPTY;

        try {
            if (StringUtils.isNotEmpty(dateStr)) {
                dateStr = dateStr.replaceAll(" ", "");
                String tempDate = dateStr.substring(0, 10);
                String tempTime = dateStr.substring(11, 19);
                if (!"1905-03-14".equals(tempDate)) {
                    result = tempDate + " " + tempTime;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 获取当月第一天日期
     *
     * @return
     */
    public static Date getFirstDayOfCurrMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取时间间隔天数
     *
     * @param startDate Date 开始时间
     * @param endDate   Date 结束时间
     * @return
     */
    public static Long getDaysInterval(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
    }

    /**
     * 获取日期的最晚时间
     *
     * @param date Date
     * @return Date
     */
    public static Date getLatestTimeOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取日期的最早时间
     *
     * @param date Date
     * @return Date
     */
    public static Date getEarliestTimeOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取"yyyyMMdd"日期整数值
     *
     * @param date Date
     * @return int
     */
    public static int dateToInt(Date date) {
        int intDate = Integer.valueOf(intDateFormat.format(date));
        return intDate;
    }

    /**
     * 获取"yyyyMMdd"日期整数值
     *
     * @param dateStr String yyyy-MM-dd
     * @return Integer
     */
    public static Integer shortStrDateToInt(String dateStr) {
        Integer date = null;

        if (StringUtils.isNotEmpty(dateStr)) {
            Date temp = DateUtil.strToShortDate(dateStr);
            date = DateUtil.dateToInt(temp);
        }

        return date;
    }

    public static String date2MinuteStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATA_MINUTE_STRING);
        return format.format(date);
    }
}
