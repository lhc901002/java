package org.michaelliu.demo.java.thread.cas;

/**
 * Created by Michael on 8/5/16.
 */
public class CasValue {

    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int curValue = value;
        if (curValue == expectedValue) {
            value = newValue;
        }
        return curValue;
    }

}
