package com.ctci;

/**
 * Created by baidu on 1/4/17.
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int value) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (value == array[middle]) {
                return middle;
            } else if (value < array[middle]) {
                if (array[middle] < array[right] || value >= array[left]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (array[middle] > array[right] || value <= array[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    public static int binarySearch(String[] strs, String s) {
        int left = 0, right = strs.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 1;
            int midPtn = middle;  // store a copy of middle in case of changing value
            while (middle <= right && strs[middle].equals("")) {
                middle++;
            }
            if (middle <= right) {
                if (strs[middle].equals(s)) {
                    return middle;
                } else if (s.compareTo(strs[middle]) < 0) {
                    right = midPtn - 1;
                    while (left <= right && strs[right].equals("")) {
                        right--;
                    }
                } else {
                    left = middle + 1;
                    while (left <= right && strs[left].equals("")) {
                        left++;
                    }
                }
            } else {
                right = midPtn - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] strs = {"", "", "haha", "", "", "", "", "hello", "hulala", "", "", "", "", "", "", "", ""};
        System.out.println(binarySearch(strs, "hello"));   // 7
        System.out.println(binarySearch(strs, "h"));       // -1
        System.out.println(binarySearch(strs, "how"));     // -1
        System.out.println(binarySearch(strs, "hype"));    // -1
        String[] strs2 = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        System.out.println(binarySearch(strs2, "hello"));  // -1
    }

//    public static void main(String[] args) {
//        int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
//        // test existing elements
//        System.out.println(binarySearch(array, 15));
//        System.out.println(binarySearch(array, 16));
//        System.out.println(binarySearch(array, 19));
//        System.out.println(binarySearch(array, 20));
//        System.out.println(binarySearch(array, 25));
//        System.out.println(binarySearch(array, 1));
//        System.out.println(binarySearch(array, 3));
//        System.out.println(binarySearch(array, 4));
//        System.out.println(binarySearch(array, 5));
//        System.out.println(binarySearch(array, 7));
//        System.out.println(binarySearch(array, 10));
//        System.out.println(binarySearch(array, 14));
//        // test non-existing elements
//        System.out.println(binarySearch(array, 2));
//        System.out.println(binarySearch(array, 13));
//        System.out.println(binarySearch(array, 0));
//        System.out.println(binarySearch(array, 30));
//    }
}
