package com.michael.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 类MyDateUtil
 *
 * @author liuhaocheng
 * @since 2016-06-15.
 */
public class MyDateUtils {

    /**
     * 获取特定日期时间前后日期时间，正数表示特定时间之后，负数表示特定时间之前。
     * @author liuhaocheng
     * @param date 日期时间
     * @param year 年
     * @param month 月
     * @param day 日
     * @param hour 时
     * @param minute 分
     * @param second 秒
     * @return 调整之后的时间
     */
    public static Date getDateRange(Date date, int year, int month, int day,
                                    int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (year != 0) {
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + year);
        }
        if (month != 0) {
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
        }
        if (day != 0) {
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + day);
        }
        if (hour != 0) {
            calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + hour);
        }
        if (minute != 0) {
            calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + minute);
        }
        if (second != 0) {
            calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + second);
        }
        return calendar.getTime();
    }
    
}
