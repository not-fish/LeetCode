package com.leetcode.easy;

/**
 * @author Peko
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

     public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
     }
}
