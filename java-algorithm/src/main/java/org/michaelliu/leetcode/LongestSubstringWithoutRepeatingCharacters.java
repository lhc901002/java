package org.michaelliu.leetcode;

import java.util.Arrays;

/**
 * Created by Michael on 1/25/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int length = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (left < charMap[s.charAt(i)] + 1) {
                left = charMap[s.charAt(i)] + 1;
            }
//            if (charMap[s.charAt(i)] != -1) {
//                left = Math.max(left, charMap[s.charAt(i)] + 1);
//            }
            length = Math.max(length, i - left + 1);
            charMap[s.charAt(i)] = i;
        }
        return length;
    }

    public static String longestSubstring(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int length = 0, left = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (left < charMap[s.charAt(i)] + 1) {
                left = charMap[s.charAt(i)] + 1;
            }
            if (length < i - left + 1) {
                length = i - left + 1;
                start = left;
            }
            charMap[s.charAt(i)] = i;
        }
        return s.substring(start, start + length);
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabcbb"));
        System.out.println(longestSubstring("a"));
        System.out.println(longestSubstring("abcd"));
        System.out.println(longestSubstring("abacd"));
        System.out.println(longestSubstring("abcdeea"));
        System.out.println(longestSubstring("bbbbb"));
        System.out.println(longestSubstring("pwwkew"));
    }
}
