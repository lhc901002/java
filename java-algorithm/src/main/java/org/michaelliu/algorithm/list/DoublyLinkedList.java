package org.michaelliu.algorithm.list;

/**
 * Created by Michael on 2016/6/25.
 */
public class DoublyLinkedList<T> {

    private DoublyLinkedListNode<T> head;

    public DoublyLinkedList(DoublyLinkedListNode<T> head) {
        this.head = head;
    }

    public void insertHead(DoublyLinkedListNode<T> node) {
        node.setNext(head);
        head.setPrev(node);
        head = node;
    }

    public void remove(DoublyLinkedListNode<T> node) {
        if (node.getPrev() != null && node.getNext() != null) {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        } else if (node == head) {
            head = node.getNext();
        } else {
            node.getPrev().setNext(null);
        }
    }

    public DoublyLinkedListNode<T> search(T key) {
        DoublyLinkedListNode<T> ptr = head;
        while (ptr != null) {
            if (ptr.getKey() == key) {
                return ptr;
            }
            ptr = ptr.getNext();
        }
        return null;
    }

}
