package org.michaelliu.leetcode;

/**
 * Created by Michael on 2/15/17.
 */
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int index = partition(nums, left, right);
            if (index + 1 == k) {
                return nums[index];
            } else if (index + 1 < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int left, int right) {
        int i = left - 1, j = left;
        int pivot = nums[right];
        while (j < right) {
            if (nums[j] > pivot) {
                i++;
                swap(nums, i, j);
                j++;
            }
        }
        // Insert pivot into partition point
        for (int k = right; k > left; k--) {
            nums[k] = nums[k - 1];
        }
        nums[i + 1] = pivot;
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
