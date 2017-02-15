package org.michaelliu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 2/15/17.
 */
public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length < 2) {
            return list;
        }
        for (int n : nums) {
            n = Math.abs(n);
            if (nums[n - 1] < 0) {
                list.add(n);
            } else {
                nums[n - 1] *= -1;
            }
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length < 2) {
            return list;
        }
        for (int n : nums) {
            n = Math.abs(n);
            if (nums[n - 1] > 0) {
                nums[n - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
