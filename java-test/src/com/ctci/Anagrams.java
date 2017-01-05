package com.ctci;

import java.util.Arrays;

public class Anagrams {

    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s1.equals("") || s2 == null || s2.equals("")) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s1, String s2) {
        if (s1 == null || s1.equals("") || s2 == null || s2.equals("")) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] chs = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            int ch = s1.charAt(i);
            chs[ch]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int ch = s2.charAt(i);
            chs[ch]--;
        }
        for (int i = 0; i < 256; i++) {
            if (chs[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("", "a"));         // print 'false'
        System.out.println(isAnagram("a", null));       // print 'false'
        System.out.println(isAnagram("a", "ab"));       // print 'false'
        System.out.println(isAnagram("a", "a"));        // print 'true'
        System.out.println(isAnagram("a", "b"));        // print 'false'
        System.out.println(isAnagram("evil", "vile"));  // print 'true'
        System.out.println(isAnagram("evil", "vily"));  // print 'false'
    }
}
