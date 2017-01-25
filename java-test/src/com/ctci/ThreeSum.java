package com.ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Michael on 1/19/17.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        // For empty array or array containing less than 3 elements, return empty result.
        if (nums == null || nums.length < 3) {
            return triplets;
        }
        Arrays.sort(nums);
        // If elements are all positive or all negative, no solution available
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return triplets;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            // pass element with the same value as its predecessor
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    triplets.add(triplet);
                    // pass elements with same value as nums[left]
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // pass elements with same value as nums[right]
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }

    public static Integer threeSumClosest(int[] nums, int target) {
        // For empty array or array containing less than 3 elements, return empty result.
        if (nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            // pass element with the same value as its predecessor
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    if (minGap > target - sum) {
                        minGap = target - sum;
                        result = sum;
                    }
                    left++;
                } else {
                    if (minGap > sum - target) {
                        minGap = sum - target;
                        result = sum;
                    }
                    right--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumClosest2(int[] nums, int target) {
        // For empty array or array containing less than 3 elements, return empty result.
        if (nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
        for (int i = 0; i < nums.length - 2; i++) {
            // pass element with the same value as its predecessor
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    minGap = 0;
                    putIntoMap(map, new int[]{nums[i], nums[left], nums[right]}, minGap);
                    // pass elements with same value as nums[left]
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // pass elements with same value as nums[right]
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    if (minGap >= target - sum) {
                        minGap = target - sum;
                        putIntoMap(map, new int[] {nums[i], nums[left], nums[right]}, minGap);
                    }
                    left++;
                } else {
                    if (minGap >= sum - target) {
                        minGap = sum - target;
                        putIntoMap(map, new int[] {nums[i], nums[left], nums[right]}, minGap);
                    }
                    right--;
                }
            }
        }
        return map.get(minGap);
    }

    static Map<Integer, List<List<Integer>>> putIntoMap(Map<Integer, List<List<Integer>>> map, int[] nums, int minGap) {
        List<List<Integer>> triplets;
        if (map.containsKey(minGap)) {
            triplets = map.get(minGap);
        } else {
            triplets = new ArrayList<List<Integer>>();
            map.put(minGap, triplets);
        }
        List<Integer> triplet = new ArrayList<Integer>();
        triplet.add(nums[0]);
        triplet.add(nums[1]);
        triplet.add(nums[2]);
        triplets.add(triplet);
        map.put(minGap, triplets);
        return map;
    }

    public static List<List<Integer>> threeSumClosest3(int[] nums, int target) {
        // For empty array or array containing less than 3 elements, return empty result.
        if (nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        int result = 0;
        // first loop, get the appropriate sum
        for (int i = 0; i < nums.length - 2; i++) {
            // pass element with the same value as its predecessor
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            boolean flag = false;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    result = sum;
                    flag = true;
                    break;
                } else if (sum < target) {
                    if (minGap > target - sum) {
                        minGap = target - sum;
                        result = sum;
                    }
                    left++;
                } else {
                    if (minGap > sum - target) {
                        minGap = sum - target;
                        result = sum;
                    }
                    right--;
                }
            }
            if (flag) {
                break;
            }
        }

        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        // second loop, get triplets
        for (int i = 0; i < nums.length - 2; i++) {
            // pass element with the same value as its predecessor
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == result) {
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    triplets.add(triplet);
                    // pass elements with same value as nums[left]
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // pass elements with same value as nums[right]
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < result) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] nums = {5, -2, 3, -4, 2};
//        List<List<Integer>> triplets = threeSum(nums);
//        System.out.println(triplets);
//
//        int[] a = {1, 2};
//        int[] b = {1, 2};
//        System.out.println(a.equals(b));

//        Integer result = threeSumClosest(nums, 0);
        List<List<Integer>> triplets = threeSumClosest3(nums, 0);
        System.out.println(triplets);
    }
}
