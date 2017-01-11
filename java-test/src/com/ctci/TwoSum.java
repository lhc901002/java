package com.ctci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] {nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int remSum = target - nums[i];
            if (remSum < 0) {
                break;
            } else {
                if (binarySearch(nums, i + 1, nums.length - 1, remSum)) {
                    return new int[] {nums[i], remSum};
                }
            }
        }
        return null;
    }

    private static boolean binarySearch(int[] nums, int left, int right, int number) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == number) {
                return true;
            } else if (nums[mid] < number) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static int[] twoSum3(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int remSum = target - num;
            if (set.contains(remSum)) {
                if (num != remSum || count(nums, remSum) > 1) {
                    return new int[] {num, remSum};
                }
            } else {
                set.add(num);
            }
        }
        return null;
    }

    private static int count(int[] nums, int number) {
        int count = 0;
        for (int num : nums) {
            if (num == number) {
                count++;
            }
        }
        return count;
    }

    public static int[] twoSum4(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remSum = target - nums[i];
            if (map.containsKey(remSum)) {
                if (remSum != nums[i] || i != map.get(remSum)) {
                    return new int[] {map.get(remSum), i};
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] array1 = {5, 3, 7, 10, 1};
        int[] array2 = {5, 3, 7, 10, 3};
        int[] array3 = {5, 3, 7, 10, 2};
        int[] array4 = {};
        int[] array5 = {6};

        int[] result1 = twoSum4(array1, 6);
        int[] result2 = twoSum4(array2, 6);
        int[] result3 = twoSum4(array3, 6);
        int[] result4 = twoSum4(array4, 6);
        int[] result5 = twoSum4(array5, 6);
        System.out.println(Arrays.toString(result1));  // [1, 5]
        System.out.println(Arrays.toString(result2));  // [3, 3]
        System.out.println(Arrays.toString(result3));  // null
        System.out.println(Arrays.toString(result4));  // null
        System.out.println(Arrays.toString(result5));  // null
    }

//    public static void main(String[] args) {
//        System.out.println(add(15, 22));
//    }

}
