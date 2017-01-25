package com.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Michael on 1/12/17.
 */
public class TimeZoneTest {

    public static void getTimeZone(Date date, TimeZone zone1, TimeZone zone2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(zone1);
        String date1 = df.format(date);
        System.out.println("date1: " + date1);
        df.setTimeZone(zone2);
        String date2 = df.format(date);
        System.out.println("date2: " + date2);
    }

    public static void main(String[] args) {
        getTimeZone(new Date(), TimeZone.getTimeZone("CST"), TimeZone.getTimeZone("Greenwich"));
    }
}
