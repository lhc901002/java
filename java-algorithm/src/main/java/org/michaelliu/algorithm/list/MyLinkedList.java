package org.michaelliu.algorithm.list;

/**
 * Created by Michael on 2/6/17.
 */
public class MyLinkedList {

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode middleNode2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }
        return slow;
    }

    public static void printList(ListNode head) {
        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode mid = middleNode2(head);
        printList(head);
        System.out.println(mid.val);
    }
}
