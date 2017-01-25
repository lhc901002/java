package com.ctci;

/**
 * Created by Michael on 1/25/17.
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int single = nums[0];
        for (int i = 1; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, -4, 5, 3, 1, 5};
        System.out.println(singleNumber(nums));
    }
}
