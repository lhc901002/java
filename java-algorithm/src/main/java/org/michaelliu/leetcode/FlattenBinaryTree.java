package org.michaelliu.leetcode;

import org.michaelliu.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 2/6/17.
 */
public class FlattenBinaryTree {

    private List<TreeNode> nodeList = new ArrayList<TreeNode>();

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root);
        TreeNode cur = root;
        // The first element will always be root.
        for (int i = 1; i < nodeList.size(); i++) {
            cur.left = null;
            cur.right = nodeList.get(i);
            cur = cur.right;
        }
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        nodeList.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
