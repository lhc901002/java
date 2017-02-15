package org.michaelliu.leetcode;

import org.michaelliu.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Michael on 2/7/17.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<Integer>();
            TreeNode levelFirstNode = null;
            while (!queue.isEmpty() && queue.peek() != levelFirstNode) {
                TreeNode curNode = queue.poll();
                if (levelFirstNode == null) {
                    levelFirstNode = curNode.left == null ? curNode.right : curNode.left;
                }
                levelList.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            resultList.add(levelList);
        }
        return resultList;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (root == null) {
            return resultList;
        }
        // Get the first node in each level
        Set<TreeNode> levelSet = new HashSet<TreeNode>();
        TreeNode cur = root;
        while (cur.left != null || cur.right != null) {
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
            levelSet.add(cur);
        }

        // BFS and store each level
        // Initially, add root into queue and create a list storing root level
        Queue<TreeNode> bfsQueue = new LinkedList<TreeNode>();
        bfsQueue.offer(root);
        List<Integer> levelList = new ArrayList<Integer>();
        resultList.add(levelList);
        while (!bfsQueue.isEmpty()) {
            cur = bfsQueue.poll();
            if (levelSet.contains(cur)) {
                levelList = new ArrayList<Integer>();
                resultList.add(levelList);
            }
            levelList.add(cur.val);
            if (cur.left != null) {
                bfsQueue.offer(cur.left);
            }
            if (cur.right != null) {
                bfsQueue.offer(cur.right);
            }
        }
        return resultList;
    }
}
