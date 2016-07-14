package org.mliuframework.java.algorithm.list;

/**
 * Created by Michael on 2016/6/25.
 */
public class DoublyLinkedListNode<T> {

    private T key;

    private DoublyLinkedListNode<T> prev;

    private DoublyLinkedListNode<T> next;

    public DoublyLinkedListNode(T key) {
        this(key, null, null);
    }

    public DoublyLinkedListNode(T key, DoublyLinkedListNode<T> prev, DoublyLinkedListNode<T> next) {
        this.key = key;
        this.prev = prev;
        this.next = next;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public DoublyLinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedListNode<T> prev) {
        this.prev = prev;
    }

    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }

}
