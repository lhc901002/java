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

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return null;
        }
        int prefixLength = 0;  // length of longest common prefix
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == prefixLength || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, prefixLength);
                }
            }
            prefixLength++;
        }
        return strs[0].substring(0, prefixLength);
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int prefixLength = strs[0].length();  // length of longest common prefix
        for (int i = 1; i < strs.length; i++) {
            // compare strs[0] to strs[i] and get the size of longest common prefix of both strings
            int size = Math.min(prefixLength, strs[i].length());
            int j;
            for (j = 0; j < size; j++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            if (j < prefixLength) {
                prefixLength = j;
            }
        }
        return strs[0].substring(0, prefixLength);
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0
                || needle == null || needle.length() == 0
                || haystack.length() < needle.length()) {
            return -1;
        }
        int start = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                start = i;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(start + j) != needle.charAt(j)) {
                        start = -1;
                        break;
                    }
                }
                if (start != -1) {
                    break;
                }
            }
        }
        return start;
    }

    public static int strStr2(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0
                || needle == null || needle.length() == 0
                || haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean isMatch = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                return i;
            }
        }
        return -1;
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = 0, end = s.length() - 1;
        // trim empty space at the end of string
        while (s.charAt(end) == ' ') {
            end--;
        }
        for (int i = end; i >=0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World  "));
    }
}
