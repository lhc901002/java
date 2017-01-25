package com.test;

/**
 * Created by Michael on 1/16/17.
 */
public class TestString {
    public static void main(String[] args) {
        String s = "";
        for (int i = 0; i < 1000; i++) {
            s += i;
        }
        System.gc();
        System.out.println(Runtime.getRuntime().freeMemory());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }
        System.gc();
        System.out.println(Runtime.getRuntime().freeMemory());
    }
}
