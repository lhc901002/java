package org.michaelliu.leetcode;

import org.michaelliu.algorithm.tree.TreeNode;

/**
 * Created by Michael on 2/6/17.
 */
public class SortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, left, mid - 1);
        root.right = createBST(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {

    }
}
