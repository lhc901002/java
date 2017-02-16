package org.michaelliu.leetcode;

/**
 * Created by Michael on 2/16/17.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxLocal = nums[0], maxGlobal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxLocal = Math.max(maxLocal + nums[i], nums[i]);
            maxGlobal = Math.max(maxLocal, maxGlobal);
        }
        return maxGlobal;
    }

    public int maxProduct(int[] nums) {
        int maxLocal = nums[0], minLocal = nums[0], global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxLocalCopy = maxLocal;
            maxLocal = Math.max(Math.max(maxLocal * nums[i], nums[i]), minLocal * nums[i]);
            minLocal = Math.min(Math.min(maxLocalCopy * nums[i], nums[i]), minLocal * nums[i]);
            global = Math.max(global, maxLocal);
        }
        return global;
    }
}
