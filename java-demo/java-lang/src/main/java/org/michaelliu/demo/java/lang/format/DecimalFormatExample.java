package org.michaelliu.demo.java.lang.format;

import java.text.DecimalFormat;

/**
 * Created by Michael on 7/28/16.
 * DecimalFormat can be put in TypeHandler to format data fetched from database
 */
public class DecimalFormatExample {

    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat();
        // 每三位用,隔开
        formatter.applyPattern("###,###.###");
        System.out.println(formatter.format(1111111234.222134)); // 1,111,111,234.222
        // 保留1位小数
        formatter.applyPattern("#.#");
        System.out.println(formatter.format(1234.222134)); // 1234.2
        // 至少6位，保留2位小数
        formatter.applyPattern("000,000.00");
        System.out.println(formatter.format(1234.222134)); // 001,234.22
        // 带$单位
        formatter.applyPattern("$###,###.00");
        System.out.println(formatter.format(1234.222134)); // $1,234.22
        // 带中文单位
        formatter.applyPattern("###,###个");
        System.out.println(formatter.format(1234.222134)); // 1,234个
        // 百分数
        formatter.applyPattern("0.00%");
        System.out.println(formatter.format(0.05435)); // 5.44%
        // 科学计数
        formatter.applyPattern("0.00E000");
        System.out.println(formatter.format(1111111234.222134)); // 1.11E009
    }

}
