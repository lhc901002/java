package com.ctci;

public class Test {
    public static boolean isUnique(String s) {
        boolean[] chars = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (chars[ch]) {
                return false;
            } else {
                chars[ch] = true;
            }
        }
        return true;
    }

//    public static boolean isUnique2() {
//
//    }

    public static void main(String[] args) {
//        String s = "hello";
//        System.out.println(isUnique3(s));
//        s = "children";
//        System.out.println(isUnique3(s));
//        int a = 1, b = 2;
//        a ^= b;
//        b ^= a;
//        a ^= b;
//        System.out.println(a + " " + b);
        System.out.println(Math.pow(2, 64));
        System.out.println(Float.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
    }

    private static boolean isUnique2(String s) {
        int check = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if ((check & (1 << ch)) > 0) {
                return false;
            } else {
                check |= (1 << ch);
            }
        }
        return true;
    }

    private static boolean isUnique3(String s) {
        int[] check = new int[8];
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            int pos = ch / 32;
            int shift = ch % 32;
            if ((check[pos] & (1 << shift)) > 0) {
                return false;
            } else {
                check[pos] |= (1 << shift);
            }
        }
        return true;
    }
}
