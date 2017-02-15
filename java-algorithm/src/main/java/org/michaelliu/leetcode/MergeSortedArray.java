package org.michaelliu.leetcode;

/**
 * Created by Michael on 2/14/17.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return;
        }
        int index = m + n - 1, index1 = m - 1, index2 = n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index] = nums1[index1];
                index1--;
            } else {
                nums1[index] = nums2[index2];
                index2--;
            }
            index--;
        }
        // Since nums1 stores the final result after merging, we only copy the remaining elements in nums2 to nums1.
        // No need to do the same for nums1.
        while (index2 >= 0) {
            nums1[index] = nums2[index2];
            index--;
            index2--;
        }
    }
}
