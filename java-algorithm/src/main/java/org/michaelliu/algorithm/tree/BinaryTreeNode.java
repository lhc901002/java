package org.michaelliu.algorithm.tree;

/**
 * Created by Michael on 2016/6/20.
 */
public class BinaryTreeNode<E extends Comparable<E>> {

    private E key;

    private BinaryTreeNode<E> left;

    private BinaryTreeNode<E> right;

    private BinaryTreeNode<E> parent;

    public BinaryTreeNode(E key) {
        this.key = key;
        left = null;
        right = null;
        parent = null;
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public BinaryTreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<E> left) {
        this.left = left;
    }

    public BinaryTreeNode<E> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<E> right) {
        this.right = right;
    }

    public BinaryTreeNode<E> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode<E> parent) {
        this.parent = parent;
    }

}
