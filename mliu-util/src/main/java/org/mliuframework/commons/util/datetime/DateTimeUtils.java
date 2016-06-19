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

    public static Date addDays(final Date datetime, int days) {
        return DateUtils.addDays(datetime, days);
    }

}
