package com.leetcode.easy;

/**
 * @author Peko
 *
 * 删除排序链表中的重复元素
 *      给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 解题思路1：
 *      循环链表，判断当前节点是否与下一节点的值相同，如果相同则把当前节点的地址换成下一节点的地址
 *
 * 效率：
 *      O(N)  0ms    100%
 *      O(1)  38MB   62.35%
 *
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
