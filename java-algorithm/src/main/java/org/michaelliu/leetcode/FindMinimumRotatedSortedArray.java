package org.michaelliu.leetcode;

/**
 * Created by Michael on 2/15/17.
 */
public class FindMinimumRotatedSortedArray {

    /** Problem 153 */

    /**
     * Sequential Search
     * T = O(N)
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * Binary Search
     */
    public int findMin2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (mid > left && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (mid < right && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    /**
     * Binary Search (This code is concise and logic clear)
     */
    public int findMin3(int[] nums) {
        // without rotation, the first element has the minimum value
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mid < right && nums[mid] > nums[mid + 1]) {
                break;
            } else if (nums[left] > nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[mid + 1];
    }
}
