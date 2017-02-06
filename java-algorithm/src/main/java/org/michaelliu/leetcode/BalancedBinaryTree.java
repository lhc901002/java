package org.michaelliu.leetcode;

import org.michaelliu.algorithm.tree.TreeNode;

/**
 * Created by Michael on 2/6/17.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = depth(root.left), rightDepth = depth(root.right);
        int dif = Math.abs(leftDepth - rightDepth);
        if (dif > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left) + 1, depth(root.right) + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);

        root.left = node3;
        root.right = node8;
        root.left.left = node2;
        root.left.right = node4;
        root.right.left = node7;
//        root.right.left.left = node6;

        System.out.println(new BalancedBinaryTree().isBalanced(root.right));
    }

}
