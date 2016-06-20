package org.mliuframework.commons.util.datetime;

import java.util.Date;

public class TestDateTimeUtils {

    public static void main(String[] args) {
        String currentDateTime = DateTimeUtils.getCurrentDateTime();
        System.out.println(currentDateTime);
        Date newTime = DateTimeUtils.addDays(new Date(), -12);
        System.out.println(DateTimeFormatUtils.format(newTime));
    }

}
