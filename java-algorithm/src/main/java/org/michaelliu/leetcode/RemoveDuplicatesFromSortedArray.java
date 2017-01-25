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
                continue;
            }
            nums[i - count] = nums[i];
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
