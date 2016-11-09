package com.test;

import java.math.BigDecimal;

public class TestDecimal {
    public static void main(String[] args) {
        BigDecimal b1 = BigDecimal.valueOf(0.06).add(BigDecimal.valueOf(0.01));
        BigDecimal b2 = BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(0.42));
        BigDecimal b3 = BigDecimal.valueOf(4.015).multiply(BigDecimal.valueOf(100));
        BigDecimal b4 = BigDecimal.valueOf(303.1).divide(BigDecimal.valueOf(1000));
        System.out.println(b1);  // 0.07
        System.out.println(b2);  // 0.58
        System.out.println(b3);  // 401.500
        System.out.println(b4);  // 0.3031
    }
}
