package com.jvm;

/**
 * 类TestLocalSlot
 *
 * @author liuhaocheng
 * @since 2016-12-12
 */
public class TestLocalSlot {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
