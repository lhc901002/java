package org.michaelliu.demo.java.lang.format;

/**
 * Created by Michael on 7/28/16.
 */
public class StringFormatExample {

    public static void main(String[] args) {
        // int数字,分割展示
        String value = String.format("%,d", Integer.MAX_VALUE); // "2,147,483,647"
        System.out.println(value);
        // int数字5位，少于5位用0补齐。
        value = String.format("%05d", 123); // 00123
        System.out.println(value);
    }

}
