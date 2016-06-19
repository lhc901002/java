package org.mliuframework.commons.util.datetime;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Michael on 2016/6/19.
 */
public class DateTimeFormatUtils {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd hh:mm:ss";

    public static String format(final Date datetime) {
        return format(datetime, DEFAULT_PATTERN);
    }

    public static String format(final Date datetime, final String pattern) {
        return DateFormatUtils.format(datetime, pattern);
    }

    public static String format(final String datetime) throws ParseException {
        return format(datetime, DEFAULT_PATTERN);
    }

    public static String format(final String datetime, final String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(datetime);
        return DateFormatUtils.format(date, pattern);
    }

    public static String format(final long milliseconds) {
        return format(milliseconds, DEFAULT_PATTERN);
    }

    public static String format(final long milliseconds, final String pattern) {
        return DateFormatUtils.format(milliseconds, pattern);
    }



}
