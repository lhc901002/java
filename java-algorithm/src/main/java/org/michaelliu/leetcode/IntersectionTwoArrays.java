package org.michaelliu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Michael on 2/15/17.
 */
public class IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        // Copy all elements from result set to result array
        int[] result = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        for (int k = 0; k < result.length; k++) {
            result[k] = iter.next();
        }
        return result;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set1 = new HashSet<Integer>(); // Store non-duplicated elements in nums1
        HashSet<Integer> set2 = new HashSet<Integer>(); // Store intersect elements of both arrays
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        // Copy all elements from result set to result array
        int[] result = new int[set2.size()];
        Iterator<Integer> iter = set2.iterator();
        for (int i = 0; i < result.length; i++) {
            result[i] = iter.next();
        }
        return result;
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();  // Store intersect elements (with duplicates) of both arrays
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        // Copy all elements from result list to result array
        int[] result = new int[list.size()];
        Iterator<Integer> iter = list.iterator();
        for (int k = 0; k < result.length; k++) {
            result[k] = iter.next();
        }
        return result;
    }
}
