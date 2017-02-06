package org.michaelliu.algorithm.list;

/**
 * Created by Michael on 2/6/17.
 */
public class MyLinkedList {

    public static void printList(ListNode head) {
        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode next = node.next;
        next = new ListNode(2);
        printList(node);
    }
}
