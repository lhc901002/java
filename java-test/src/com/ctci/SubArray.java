package com.ctci;

/**
 * Created by Michael on 1/13/17.
 */
public class SubArray {
    public static int maxSum(int[] nums) {
        int maxLocal = nums[0], maxGlobal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxLocal = Math.max(maxLocal + nums[i], nums[i]);
            maxGlobal = Math.max(maxGlobal, maxLocal);
        }
        return maxGlobal;
    }

    public static int maxProduct(int[] nums) {
        int maxLocal = nums[0], minLocal = nums[0], global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxLocalCopy = maxLocal;
            maxLocal = Math.max(Math.max(maxLocal * nums[i], nums[i]), minLocal * nums[i]);
            minLocal = Math.min(Math.min(maxLocalCopy * nums[i], nums[i]), minLocal * nums[i]);
            global = Math.max(global, maxLocal);
        }
        return global;
    }

    public static void main(String[] args) {
        int[] array = {-1, -6, -2, -1, -3};
        System.out.println(maxSum(array));
    }
}
