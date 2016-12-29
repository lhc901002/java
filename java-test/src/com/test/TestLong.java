package com.test;

/**
 * 类TestLong
 *
 * @author liuhaocheng
 * @since 2016-12-20
 */
public class TestLong {
    public static void main(String[] args) {
        Long l = new Long(0);
        System.out.println(!(l > 0 || l < 0));
        Object i = 0;
        System.out.println(i instanceof Long);  // print 'false'
    }
}
