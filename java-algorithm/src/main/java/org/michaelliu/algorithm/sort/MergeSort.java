package org.michaelliu.algorithm.sort;

/**
 * Created by Michael on 2016/6/25.
 */
public class MergeSort {

    public static void doSort(int [] array, int order) {
        if (array.length > 1) {
            int[] tmpArray = new int [array.length];
            doSort(array, tmpArray, 0, array.length - 1, order);
        }
    }

    public static void doSort(int [] array, int [] tmpArray,
                              int start, int end, int order) {
        if (array.length > 1 && start < end) {
            int middle = (start + end) >> 1;
            doSort(array, tmpArray, start, middle, order);
            doSort(array, tmpArray, middle + 1, end, order);
            merge(array, tmpArray, start, middle, end, order);
        }
    }

    private static void merge(int [] array, int [] tmpArray, int start,
                              int middle, int end, int order) {
        int i = start, j = middle + 1, k = start;
        while (i <= middle && j <= end) {
            if (array[i] <= array[j]) {
                if (order == SortMark.ASCENDING_ORDER) {
                    tmpArray[k++] = array[i++];
                } else {
                    tmpArray[k++] = array[j++];
                }
            } else {
                if (order == SortMark.ASCENDING_ORDER) {
                    tmpArray[k++] = array[j++];
                } else {
                    tmpArray[k++] = array[i++];
                }
            }
        }
        while (i <= middle) {
            tmpArray[k++] = array[i++];
        }
        while (j <= end) {
            tmpArray[k++] = array[j++];
        }
        for (int index = start; index <= end; index++) {
            array[index] = tmpArray[index];
        }
    }

}
