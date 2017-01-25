package org.michaelliu.leetcode;

/**
 * Created by Michael on 1/25/17.
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[mid] > target) {
            return mid;
        } else {
            return mid + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        System.out.println(searchInsert(nums, 2));
    }
}
