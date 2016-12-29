package com.test;

/**
 * 类TestBoxing
 *
 * @author liuhaocheng
 * @since 2016-12-02
 */
public class TestBoxing {
    private static final Integer MAX = 10;

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(s.length() > MAX);
    }
}
