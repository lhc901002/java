package org.mliuframework.commons.util.exception;

/**
 * Created by Michael on 2016/6/19.
 */
public class DateTimeFormatException extends Exception {

    public DateTimeFormatException() {
        super("Datetime format encounters an exception");
    }

    public DateTimeFormatException(String message) {
        super(message);
    }

}
