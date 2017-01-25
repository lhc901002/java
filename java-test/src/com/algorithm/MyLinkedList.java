package com.algorithm;

import java.util.Stack;

/**
 * Created by Michael on 1/10/17.
 */
public class MyLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = head.next;
        ListNode newHead = reverseList(dummyHead);
        dummyHead.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        for (ListNode node = head; node != null; node = node.next) {
            stack.push(node);
        }
        if (stack.isEmpty()) {
            return null;
        } else {
            ListNode newHead = stack.pop();
            ListNode curNode = newHead;
            while (!stack.isEmpty()) {
                curNode.next = stack.pop();
                curNode = curNode.next;
            }
            curNode.next = null;
            return newHead;
        }
    }

    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head, cur = head.next, next;
        head.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prevStart = head, start = head;
        if (m > 1) {
            for (int i = 1; i < m - 1; i++) {
                prevStart = prevStart.next;
            }
            start = prevStart.next;
        }
        ListNode prev = start, cur = start.next;
        for (int i = m + 1; i <= n; i++) {
            if (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

        }
        start.next = cur;
        if (m > 1) {
            prevStart.next = prev;
        } else {
            head = prev;
        }
        return head;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode head;
        if (list1.value <= list2.value) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode curNode = head;
        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                curNode.next = list1;
                list1 = list1.next;
            } else {
                curNode.next = list2;
                list2 = list2.next;
            }
            curNode = curNode.next;
        }
        if (list1 != null) {
            curNode.next = list1;
        } else if (list2 != null) {
            curNode.next = list2;
        }
        return head;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        head = reverseList(head);
        head = reverseBetween(head, 1, k);
        ListNode prev = head;
        for (int i = 1; i < k; i++) {
            prev = prev.next;
        }
        prev.next = reverseList(prev.next);
        return head;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head, cur = head.next, next;
        int size = 1;
        head.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            size++;
        }
        head = prev;
        k %= size;
        head = reverseBetween(head, 1, k);
        head = reverseBetween(head, k + 1, size);
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        if (q == null) {
            head = head.next;
        } else {
            while (q.next != null) {
                p = p.next;
                q = q.next;
            }
            p.next = p.next.next;
        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.value == curNode.next.value) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode curNode = head, prev = head;
        while (curNode != null && curNode.next != null) {
            int count = 1;
            while (curNode.next != null && curNode.value == curNode.next.value) {
                count++;
                curNode = curNode.next;
            }
            if (head.value == curNode.value && head != curNode) {
                head = curNode.next;
            } else if (count > 1) {
                prev.next = curNode.next;
            } else {
                prev = curNode;
            }
            curNode = curNode.next;
        }
        return head;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast.value == slow.value) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode fast = head, slow = head;
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow);
        }
        if (fast.next == null) {
            stack.pop();
        }
        ListNode cur = slow.next;
        while (cur != null) {
            if (cur.value != stack.pop().value) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightList = reverseList(slow.next);
        for (ListNode cur = head; rightList != null; cur = cur.next, rightList = rightList.next) {
            if (cur.value != rightList.value) {
                return false;
            }
        }
        return true;
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = reverseList(slow.next);
        ListNode left = head;
        while (right != null) {
            ListNode leftPrev = left;
            ListNode rightPrev = right;
            left = left.next;
            right = right.next;
            leftPrev.next = rightPrev;
            rightPrev.next = left;
        }
        if (left != null) {
            left.next = null;
        }
    }

    ListNode insertAtHead(ListNode head, ListNode node) {
        node.next = head;
        head = node;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        reorderList(head);
        printList(head);
    }

    public static void printList(ListNode head) {
        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.value + " ");
        }
        System.out.println();
    }
}
