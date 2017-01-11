package com.ctci;

import java.util.Arrays;

public class StringQuestion {

    public static void removeDuplicate(StringBuffer s) {
        if (s == null && s.length() < 2) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    s.delete(j, j + 1);
                    j--;
                }
            }
        }
    }

    public static void removeDuplicate2(StringBuffer s) {
        if (s == null && s.length() < 2) {
            return;
        }
        int check = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if ((check & (1 << ch)) > 0) {
                s.delete(i, i + 1);
                i--;
            } else {
                check |= (1 << ch);
            }
        }
    }

    public static String replaceSpaces(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int spaceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        if (spaceCount == 0) {
            return s;
        }
        char[] chs = new char[s.length() + spaceCount * 2];
        for (int i = 0, j = 0; i < s.length() && j < chs.length; i++, j++) {
            if (s.charAt(i) == ' ') {
                chs[j] = '%';
                chs[j + 1] = '2';
                chs[j + 2] = '0';
                j += 2;
            } else {
                chs[j] = s.charAt(i);
            }
        }
        return new String(chs);
    }

    static String compressString(String str) {
        // for string less than 2 characters, no need to compress
        if (str == null || str.length() < 3) {
            return str;
        }
        StringBuffer newStr = new StringBuffer();
        newStr.append(str.charAt(0));
        char curCh = str.charAt(0);
        int curChCount = 1;
        for (int i = 1; i < str.length(); i++) {
            if (curCh == str.charAt(i)) {
                curChCount++;
            } else {
                if (curChCount > 1) {
                    newStr.append(curChCount);
                    curChCount = 1;
                }
                curCh = str.charAt(i);
                newStr.append(curCh);
            }
        }
        if (curChCount > 1) {
            newStr.append(curChCount);
        }
        if (newStr.length() < str.length()) {
            return newStr.toString();
        } else {
            return str;
        }
    }

    static void printNBitsString(int[] array, int nBits) {
        if (nBits <= 0) {
            System.out.println(Arrays.toString(array));
        } else {
            array[nBits - 1] = 0;
            printNBitsString(array, nBits - 1);
            array[nBits - 1] = 1;
            printNBitsString(array, nBits - 1);
        }
    }

    static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0, startIndex = 0;
        boolean[] ascii = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ascii[ch]) {
                maxLength = Math.max(maxLength, i - startIndex);
            } else {
                ascii[ch] = true;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        printNBitsString(new int[4], 4);
//        StringBuffer s1 = new StringBuffer("hello world");
//        StringBuffer s2 = new StringBuffer("");
//        StringBuffer s3 = new StringBuffer("a");
//        StringBuffer s4 = new StringBuffer("aaaaaaa");
//        StringBuffer s5 = new StringBuffer("ababab");
//        removeDuplicate(s1);
//        removeDuplicate(s2);
//        removeDuplicate(s3);
//        removeDuplicate(s4);
//        removeDuplicate(s5);
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);
//        System.out.println(s5);
//        String s = "i am hawstein";
//        System.out.println(replaceSpaces("i am michael"));  // i%20am%20michael
//        System.out.println(replaceSpaces("michael"));       // michael

//        String s = "ssssuuuummmmmmiiiittttttttttttt";
//        System.out.println(compressString(s));
//        s = "Jaain";
//        System.out.println(compressString(s));
    }
}
