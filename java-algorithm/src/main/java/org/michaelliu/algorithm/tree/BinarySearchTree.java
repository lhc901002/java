package org.michaelliu.algorithm.tree;

/**
 * Created by Michael on 2/6/17.
 */
public class BinarySearchTree {

    public TreeNode insert(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            TreeNode cur = root;
            TreeNode parent = null;
            while (cur != null) {
                parent = cur;
                if (node.val < cur.val) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            node.parent = parent;
            if (node.val < parent.val) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
        return root;
    }

    public TreeNode search(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (val == cur.val) {
                return cur;
            } else if (val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    public TreeNode minimum(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public TreeNode maximum(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    public TreeNode successor(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return minimum(node.right);
        }
        TreeNode cur = node, suc = node.parent;
        while (suc != null && suc.left != cur) {
            cur = suc;
            suc = suc.parent;
        }
        return suc;
    }

    public TreeNode predecessor(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return maximum(node.left);
        }
        TreeNode cur = node, pred = node.parent;
        while (pred != null && pred.right != cur) {
            cur = pred;
            pred = pred.parent;
        }
        return pred;
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode node5 = new TreeNode(5);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);

        TreeNode root = tree.insert(node5, node8);
        root = tree.insert(root, node7);
        root = tree.insert(root, node6);
        root = tree.insert(root, node3);
        root = tree.insert(root, node4);
        root = tree.insert(root, node2);
//        printTree(root);
        TreeNode node = tree.successor(node5);
        System.out.println(node.val);
    }
}
