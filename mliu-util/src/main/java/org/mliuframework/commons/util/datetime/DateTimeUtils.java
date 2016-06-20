package org.mliuframework.commons.util.datetime;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * Created by Michael on 2016/6/19.
 */
public class DateTimeUtils {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd hh:mm:ss";

    public static String getCurrentDateTime() {
        return getCurrentDateTime(DEFAULT_PATTERN);
    }

    public static String getCurrentDateTime(String pattern) {
        return DateTimeFormatUtils.format(System.currentTimeMillis(), pattern);
    }

    public static Date addYears(final Date datetime, final int years) {
        return DateUtils.addYears(datetime, years);
    }

    public static Date addMonths(final Date datetime, final int months) {
        return DateUtils.addMonths(datetime, months);
    }


    public static Date addDays(final Date datetime, final int days) {
        return DateUtils.addDays(datetime, days);
    }

    public static Date addHours(final Date datetime, final int hours) {
        return DateUtils.addHours(datetime, hours);
    }

    public static Date addMinutes(final Date datetime, final int minutes) {
        return DateUtils.addMinutes(datetime, minutes);
    }

    public static Date addSeconds(final Date datetime, final int seconds) {
        return DateUtils.addSeconds(datetime, seconds);
    }

}
