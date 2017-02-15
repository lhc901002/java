package org.michaelliu.leetcode;

import org.michaelliu.algorithm.tree.TreeNode;

/**
 * Created by Michael on 2/7/17.
 */
public class DepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }
}
