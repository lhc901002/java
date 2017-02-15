package org.michaelliu.leetcode;

import java.util.Arrays;

/**
 * Created by Michael on 1/25/17.
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int valCount = 1, count = 0;
        for (int i = 1; i < nums.length; i++) {
            // Get the number of elements with values same as current element
            if (nums[i] == nums[i - 1]) {
                valCount++;
            } else {
                valCount = 1;
            }
            // valCount > 2 means element meets 'duplicate' criteria. Count and remove duplicates.
            if (valCount > 2) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 3, 3, 4, 4, 4};
//        int[] nums = {1, 1, 2, 3, 4, 4, 4};
        int length = removeDuplicates(nums);
        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }
}
