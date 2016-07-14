package org.mliuframework.java.algorithm.list;

/**
 * Created by Michael on 2016/6/25.
 */
public class CircleLinkedList<T> {

    private DoublyLinkedListNode<T> head;

    private DoublyLinkedListNode<T> tail;

    public CircleLinkedList (DoublyLinkedListNode<T> head) {
        this.head = head;
        this.tail = head;
    }

    public CircleLinkedList insert(T key) {
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(key);
        head.setPrev(newNode);
        tail.setNext(newNode);
        newNode.setNext(head);
        newNode.setPrev(tail);
        tail = newNode;
        return this;
    }

}
