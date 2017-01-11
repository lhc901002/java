package com.ctci;

import com.algorithm.ListNode;

/**
 * Created by Michael on 1/10/17.
 */
public class TwoNumbers {

    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode pointer1 = list1, pointer2 = list2;
        ListNode lastNode = null;  // store the last node of list 1
        int carry = 0;
        while (pointer1 != null && pointer2 != null) {
            int sum = pointer1.value + pointer2.value + carry;
            int bitSum = sum % 10;
            carry = sum / 10;
            pointer1.value = bitSum;  // using list 1 to store the sum
            if (pointer1.next == null) {
                lastNode = pointer1;
            }
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        if (pointer2 != null) {
            lastNode.next = pointer2;
            pointer1 = pointer2;
        }
        while (pointer1 != null && carry > 0) {
            int sum = pointer1.value + carry;
            int bitSum = sum % 10;
            carry = sum / 10;
            pointer1.value = bitSum;  // using list 1 to store the sum
            if (pointer1.next == null) {
                lastNode = pointer1;
            }
            pointer1 = pointer1.next;
        }
        if (carry > 0) {
            lastNode.next = new ListNode(carry);
        }
        return list1;
    }

    public static void printList(ListNode list) {
        ListNode pointer = list;
        while (pointer != null) {
            System.out.print(pointer.value + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

//    public static void main(String[] args) {
//        ListNode list1 = new ListNode(2);
//        list1.next = new ListNode(4);
//        list1.next.next = new ListNode(3);
//        ListNode list2 = new ListNode(5);
//        list2.next = new ListNode(6);
//        list2.next.next = new ListNode(4);
//        printList(list1);  // 2 4 3
//        printList(list2);  // 5 6 4
//        ListNode result = addTwoNumbers(list1, list2);
//        printList(result);  // 7 0 8
//    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(9);
        list1.next = new ListNode(9);
        list1.next.next = new ListNode(9);
        ListNode list2 = new ListNode(1);
        printList(list1);  // 9 9 9
        printList(list2);  // 1
        ListNode result = addTwoNumbers(list1, list2);
        printList(result);  // 0 0 0 1
    }

}
