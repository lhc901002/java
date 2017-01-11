package com.ctci;

/**
 * Created by baidu on 1/9/17.
 */
public class MissingNumber {
    static int findMisssingNumber(int[] array, int range) {
        int N = (1 + range) * range / 2;
        int S = 0;
        for (int i : array) {
            S += i;
        }
        return N - S;
    }

    static int findMisssingNumber2(int[] array, int range) {
        int a = 0, b = 0;
        for (int i = 1; i <= range; i++) {
            a ^= i;
        }
        for (int i : array) {
            b ^= i;
        }
        return a ^ b;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 7, 6, 3, 4 };
        System.out.println(findMisssingNumber2(array, 7));
    }
}
