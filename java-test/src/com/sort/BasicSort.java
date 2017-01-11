package com.sort;

/**
 * Created by baidu on 1/5/17.
 */
public class BasicSort {

    public static void bubbleSort(int[] array) {
        boolean finishFlag = true;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] ^= array[j + 1];
                    array[j + 1] ^= array[j];
                    array[j] ^= array[j + 1];
                    finishFlag = false;
                }
            }
            if (finishFlag) {
                return;
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int minValue = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (minValue > array[j]) {
                    minIndex = j;
                    minValue = array[j];
                }
            }
            if (minIndex != i) {
                array[i] ^= array[minIndex];
                array[minIndex] ^= array[i];
                array[i] ^= array[minIndex];
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int curVal = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > curVal) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curVal;
        }
    }

    public static void heapSort(int[] array) {
        int heapSize = array.length;
        int middleIndex = parentIndex(heapSize - 1);
        while (heapSize > 0) {
            for (int i = middleIndex; i >= 0; i--) {
                int leftChildIndex = leftChildIndex(i);
                int rightChildIndex = rightChildIndex(i);
                if (array[leftChildIndex] > array[i]) {
                    if (rightChildIndex > heapSize - 1 || array[leftChildIndex] > array[rightChildIndex]) {
                        swap(array, leftChildIndex, i);
                    } else {
                        swap(array, rightChildIndex, i);
                    }
                } else if (rightChildIndex <= heapSize - 1 && array[rightChildIndex] > array[i]) {
                    swap(array, rightChildIndex, i);
                }
            }
            swap(array, 0, heapSize - 1);
            heapSize--;
            middleIndex = parentIndex(heapSize - 1);
        }
    }

    /**
     * recursion
     */
    public static void heapSort2(int[] array) {
        int heapSize = array.length;
        int startIndex = parentIndex(heapSize - 1);
        for (int i = startIndex; i >= 0; i--) {
            maxHeapify(array, heapSize, i);
        }
        for (int i = array.length - 1; i >= 1; i--) {
            swap(array, 0, i);
            heapSize--;
            maxHeapify(array, heapSize, i);
        }
    }

    private static void maxHeapify(int[] array, int heapSize, int i) {
        int leftChildIndex = leftChildIndex(i);
        int rightChildIndex = rightChildIndex(i);
        int maxIndex;
        if (leftChildIndex < heapSize && array[leftChildIndex] > array[i]) {
            maxIndex = leftChildIndex;
        } else {
            maxIndex = i;
        }
        if (rightChildIndex < heapSize && array[rightChildIndex] > array[maxIndex]) {
            maxIndex = rightChildIndex;
        }
        if (maxIndex != i) {
            swap(array, i, maxIndex);
            maxHeapify(array, heapSize, maxIndex);
        }
    }

    private static int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private static int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private static int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    private static void swap(int[] array, int i, int j) {
        if (i != j) {
            array[i] ^= array[j];
            array[j] ^= array[i];
            array[i] ^= array[j];
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 1};
        int[] array2 = {1, 2, 3, 4, 5, 6};
        int[] array3 = {4, 5, 1, 6, 3, 2};
        heapSort2(array);
//        heapSort2(array2);
//        heapSort2(array3);
        printArray(array);
//        printArray(array2);
//        printArray(array3);
    }
}
