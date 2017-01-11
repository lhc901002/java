package com.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 1/10/17.
 */
public class PeakElement {

    public int peakElement(int[] array,int left, int right){
        int mid = left + (right - left) / 2;
        if((mid == 0 || array[mid] >= array[mid - 1]) && (array[mid] >= array[mid + 1] || mid == array.length - 1)) {
            return mid;
        } else if (mid > 0 && array[mid] < array[mid - 1]) {
            return peakElement(array, left, mid - 1);
        } else {
            return peakElement(array, mid + 1, right);
        }
    }

    public static int peakElement(int[] array) {
        int peakIndex = 0, left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid == left || array[mid] >= array[mid - 1]) && (mid == right || array[mid] >= array[mid + 1])) {
                peakIndex = mid;
                break;
            } else if (mid == left || array[mid] < array[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return peakIndex;
    }

    public static List<Integer> peakElement2(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < array.length - 2; i++) {
            if (array[i - 1] <= array[i] && array[i] >= array[i + 1]) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array1 = { 1, 2, 3, 4, 0, 1, 5, 4, 3, 2, 1 };
        int[] array2 = { 1, 1, 1 };
        int[] array3 = { 1, 2, 3 };
        int[] array4 = { 3, 2, 1 };
        int[] array5 = { 1 };
        System.out.println(peakElement(array1));
        System.out.println(peakElement(array2));
        System.out.println(peakElement(array3));
        System.out.println(peakElement(array4));
        System.out.println(peakElement(array5));
    }
}
