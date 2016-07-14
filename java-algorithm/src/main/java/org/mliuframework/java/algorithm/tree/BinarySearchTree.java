package org.mliuframework.java.algorithm.tree;

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

    public BinaryTreeNode<E> predecessor(BinaryTreeNode<E> node) {
        if (node.getLeft() != null) {
            return rightMost(node.getLeft());
        } else if(node.getParent() != null && node.getParent().getRight() == node) {
            return node.getParent();
        } else {
            while(node.getParent() != null && node.getParent().getRight() != node ) {
                node = node.getParent();
            }
            return node.getParent();
        }
    }

    BinaryTreeNode leftMost(BinaryTreeNode root) {
        while(root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }

    BinaryTreeNode rightMost(BinaryTreeNode root) {
        while(root.getRight() != null) {
            root = root.getRight();
        }
        return root;
    }

    public BinarySearchTree rotateLeft (BinaryTreeNode node) {
        BinaryTreeNode nodeRight = node.getRight();
        if (nodeRight != null) {
            node.setRight(nodeRight.getLeft());
            if (nodeRight.getLeft() != null) {
                nodeRight.getLeft().setParent(node);
            }
            nodeRight.setParent(node.getParent());
            if (node.getParent() == null) {
                root = nodeRight;
            } else if (node == node.getParent().getLeft()) {
                node.getParent().setLeft(nodeRight);
            } else {
                node.getParent().setRight(nodeRight);
            }
            nodeRight.setLeft(node);
            node.setParent(nodeRight);
        }
        return this;
    }

    public BinarySearchTree rotateRight (BinaryTreeNode node) {
        BinaryTreeNode nodeLeft = node.getLeft();
        if (nodeLeft != null) {
            node.setLeft(nodeLeft.getRight());
            if (nodeLeft.getRight() != null) {
                nodeLeft.getRight().setParent(node);
            }
            nodeLeft.setParent(node.getParent());
            if (node.getParent() == null) {
                root = nodeLeft;
            } else if (node == node.getParent().getLeft()) {
                node.getParent().setLeft(nodeLeft);
            } else {
                node.getParent().setRight(nodeLeft);
            }
            nodeLeft.setRight(node);
            node.setParent(nodeLeft);
        }
        return this;
    }

}
