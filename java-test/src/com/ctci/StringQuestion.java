package com.ctci;

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

    public static void main(String[] args) {
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
        String s = "i am hawstein";
        System.out.println(replaceSpaces("i am michael"));  // i%20am%20michael
        System.out.println(replaceSpaces("michael"));       // michael
    }
}
