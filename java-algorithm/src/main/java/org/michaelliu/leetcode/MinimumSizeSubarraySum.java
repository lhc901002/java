package org.michaelliu.leetcode;

/**
 * Created by Michael on 2/16/17.
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minSizeGlobal = nums.length;
        int left = 0, right = 0;
        while (right < nums.length && left <= right) {
            int sum = sumSubArray(nums, left, right);
            if (sum >= s) {
                int minSizeLocal = right - left + 1;
                minSizeGlobal = Math.min(minSizeLocal, minSizeGlobal);
                left++;
            } else {
                right++;
            }
        }

        // If no such sum >= s, return 0.
        if (left == 0) {
            return 0;
        }
        return minSizeGlobal;
    }

    private int sumSubArray(int[] nums, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
