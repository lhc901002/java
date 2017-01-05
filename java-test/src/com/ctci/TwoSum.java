package com.ctci;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by baidu on 1/3/17.
 */
public class TwoSum {
    public static void printTwoElements(int[] array, int sum) {
        if (array == null || array.length < 2) {
            System.out.println("no two elements");
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            set.add(i);
        }
        for (int i : array) {
            int partner = sum - i;
            if (set.contains(partner) && i != partner) {
                System.out.println(i + " " + partner);
                return;
            }
        }
        System.out.println("no two elements");
    }

    public static void printTwoElements2(int[] array, int sum) {
        if (array == null || array.length < 2) {
            System.out.println("no two elements");
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, 0);
            }
        }
        for (int i : array) {
            int partner = sum - i;
            if (map.containsKey(partner)) {
                if (i != partner || map.get(i) > 0) {
                    System.out.println(i + " " + partner);
                    return;
                }
            }
        }
        System.out.println("no two elements");
    }

    public static int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(15, 22));
    }

//    public static void main(String[] args) {
//        int[] array1 = {5, 3, 7, 10, 1};
//        int[] array2 = {5, 3, 7, 10, 3};
//        int[] array3 = null;
//        int[] array4 = {};
//        int[] array5 = {6};
//        printTwoElements(array1, 6);  // 5 1
//        printTwoElements2(array2, 6);  // no two elements
//        printTwoElements(array3, 6);  // no two elements
//        printTwoElements(array4, 6);  // no two elements
//        printTwoElements(array5, 6);  // no two elements
//    }
}
