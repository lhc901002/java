package com.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Michael on 1/17/17.
 */
public class MyBinaryTree {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        return inorderTraversal2(root, list);
    }

    private static List<Integer> inorderTraversal2(TreeNode root, List<Integer> list) {
        if (root != null) {
            list = inorderTraversal2(root.left, list);
            list.add(root.val);
            list = inorderTraversal2(root.right, list);
        }
        return list;
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        List<Integer> list = new ArrayList<Integer>();
        list = inorderTraversal2(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        // check whether has same structure
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        // check whether has same value
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    static boolean isSameTree2(TreeNode p, TreeNode q) {
        if (!isSameNode(p, q)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
        leftQueue.offer(p);
        rightQueue.offer(q);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftFront = leftQueue.poll();
            TreeNode rightFront = rightQueue.poll();
            if (!isSameNode(leftFront.left, rightFront.left)) {
                return false;
            }
            if (leftFront.left != null && rightFront.left != null) {
                leftQueue.offer(leftFront.left);
                rightQueue.offer(rightFront.left);
            }

            if (!isSameNode(leftFront.right, rightFront.right)) {
                return false;
            }
            if (leftFront.right != null && rightFront.right != null) {
                leftQueue.offer(leftFront.right);
                rightQueue.offer(rightFront.right);
            }
        }
        return true;
    }

    static boolean isSameNode(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        // check whether has same structure
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        // check whether has same value
        if (p.val != q.val) {
            return false;
        }
        return true;
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null || left == null && right != null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        TreeNode node1 = root.left, node2 = root.right;
        if (node1 != null && node2 == null || node1 == null && node2 != null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(node1);
        stack2.push(node2);
        boolean flag = false;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (!flag && (node1.left != null || node2.right != null)) {
                stack1.push(node1);
                stack2.push(node2);
                node1 = node1.left;
                node2 = node2.right;
                if (node1 != null && node2 == null || node1 == null && node2 != null) {
                    return false;
                }
                if (node1.val != node2.val) {
                    return false;
                }
                stack1.push(node1);
                stack2.push(node2);
            } else if (node1.right != null || node2.left != null) {
                node1 = node1.right;
                node2 = node2.left;
                if (node1 != null && node2 == null || node1 == null && node2 != null) {
                    return false;
                }
                if (node1.val != node2.val) {
                    return false;
                }
                flag = false;
            } else {
                node1 = stack1.pop();
                node2 = stack2.pop();
                flag = true;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static List<List<Integer>> solveInDFS(int depth, TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return result;
        }
        if (result.size() > depth) {
            result.get(depth).add(root.val);
        } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            result.add(list);
        }
        result = solveInDFS(depth + 1, root.left, result);
        result = solveInDFS(depth + 1, root.right, result);
        return result;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        return solveInDFS(0, root, result);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(2);
        root2.right = new TreeNode(5);
        root2.right.right = new TreeNode(7);
        System.out.println(isSameTree2(root, root2));
    }
}
