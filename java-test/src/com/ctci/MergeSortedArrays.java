package com.ctci;

/**
 * Created by baidu on 1/4/17.
 */
public class MergeSortedArrays {

    public static Integer[] merge(Integer[] array_A, int size_A, Integer[] array_B, int size_B) {
        int beginIndex = size_A + size_B - 1;
        int indexA = size_A - 1;
        int indexB = size_B - 1;
        while (indexA >= 0 && indexB >= 0) {
            if (array_A[indexA] > array_B[indexB]) {
                array_A[beginIndex--] = array_A[indexA--];
            } else {
                array_A[beginIndex--] = array_B[indexB--];
            }
        }
        while (indexB >= 0) {
            array_A[beginIndex--] = array_B[indexB--];
        }
        return array_A;
    }

    public static void printArray(Integer[] array) {
        for (Integer i : array) {
            if (i == null) {
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] array_A = {-2, 3, 4, 6, 8, 11, null, null, null, null, null, null, null, null, null, null, null, null, null};
        Integer[] array_B = {-17, -11, -4, -2, 1, 3, 4, 5, 9, 10};
        Integer[] result = merge(array_A, 6, array_B, 10);
        printArray(result);
    }
}
