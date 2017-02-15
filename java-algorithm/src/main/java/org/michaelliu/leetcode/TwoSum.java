package org.michaelliu.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Michael on 1/25/17.
 */
public class TwoSum {

    /**
     * Hash Map
     * Time: O(N)
     * Space: O(N)
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        // key: element's value value: element's index
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int partner = target - nums[i];
            if (map.containsKey(partner)) {
                if (map.get(partner) != i) {
                    return new int[] {map.get(partner), i};
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

}
