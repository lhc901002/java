package com.ctci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Michael on 1/24/17.
 */
public class ArrayQ {

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static int removeElement2(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    public static void sortColors(int[] nums) {
        int head = 0, tail = nums.length - 1;
        for (int i = head; i <= tail; i++) {
            if (nums[i] == 2) {
                swap(nums, i, tail);
                tail--;
                i--;
            } else if (nums[i] == 0) {
                swap(nums, i, head);
                head++;
            }
        }
    }

    static void swap(int[] array, int x, int y) {
        if (x != y && array[x] != array[y]) {
            array[x] ^= array[y];
            array[y] ^= array[x];
            array[x] ^= array[y];
        }
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 2, 0, 0, 0, 1, 0, 2, 1, 1};
        int[] nums = {0, 0, 0, 1, 0, 2, 1, 0, 2, 2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
