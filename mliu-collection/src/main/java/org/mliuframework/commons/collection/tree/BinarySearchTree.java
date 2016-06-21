package org.mliuframework.commons.collection.tree;

/**
 * Created by Michael on 2016/6/20.
 */
public class BinarySearchTree <E extends Comparable<E>> {

    private BinaryTreeNode<E> root;

    public BinarySearchTree(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public BinarySearchTree<E> insertKey(E key) {
        BinaryTreeNode<E> node = new BinaryTreeNode<E>(key);
        BinaryTreeNode<E> ptr = root;
        while (true) {
            int compare = ptr.getKey().compareTo(node.getKey());
            if (compare >= 0) {
                if (ptr.getLeft() == null) {
                    node.setParent(ptr);
                    ptr.setLeft(node);
                    break;
                } else {
                    ptr = ptr.getLeft();
                }
            } else {
                if (ptr.getRight() == null) {
                    node.setParent(ptr);
                    ptr.setRight(node);
                    break;
                }
                ptr = ptr.getRight();
            }
        }
        return this;
    }

    public BinarySearchTree<E> insertNode(BinaryTreeNode<E> node) {
        BinaryTreeNode<E> ptr = root;
        while (true) {
            int compare = ptr.getKey().compareTo(node.getKey());
            if (compare >= 0) {
                if (ptr.getLeft() == null) {
                    node.setParent(ptr);
                    ptr.setLeft(node);
                    break;
                } else {
                    ptr = ptr.getLeft();
                }
            } else {
                if (ptr.getRight() == null) {
                    node.setParent(ptr);
                    ptr.setRight(node);
                    break;
                }
                ptr = ptr.getRight();
            }
        }
        return this;
    }

    public BinaryTreeNode<E> successor(BinaryTreeNode<E> node) {
        if (node.getRight() != null) {
            return leftMost(node.getRight());
        } else {
            if (node.getParent() != null && node.getParent().getLeft() == node) {
                return node.getParent();
            } else {
                while(node.getParent() != null && node.getParent().getLeft() != node) {
                    node = node.getParent();
                }
                return node.getParent();
            }
        }
    }

    public BinaryTreeNode<E> predecessor(BinaryTreeNode<E> n) {
        if (n.left != null) {
            return rightMost(n.left);
        }
        else if(n.parent != null && n.parent.right == n) {
            return n.parent;
        }
        else {
            while(n.parent != null && n.parent.right != n ) {
                n = n.parent;
            }
            return n.parent;
        }
    }

}
