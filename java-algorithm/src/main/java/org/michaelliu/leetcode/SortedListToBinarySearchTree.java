package org.michaelliu.leetcode;

import org.michaelliu.algorithm.list.ListNode;
import org.michaelliu.algorithm.tree.TreeNode;

/**
 * Created by Michael on 2/6/17.
 */
public class SortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        if (head.next.next == null) {
            TreeNode node = new TreeNode(head.val);
            node.right = new TreeNode(head.next.val);
            return node;
        }
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null) {
                break;
            }
            prev = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (prev != null) {
            prev.next = null;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
