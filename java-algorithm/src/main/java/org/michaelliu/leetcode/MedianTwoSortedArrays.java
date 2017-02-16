package org.michaelliu.leetcode;

/**
 * Created by Michael on 2/16/17.
 */
public class MedianTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int medianIndex = m + (n - m) / 2;
        int i = 0, j = 0, count = 0;
        while (i < m && j < n && count < medianIndex) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
            count++;
        }
        return 0;
    }
}
