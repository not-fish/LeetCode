package com.leetcode.easy;


/**
 * @author Peko
 *
 * 合并两个有序链表
 *
 * 解题思路：
 *      终止条件：当两个链表都为空时，表示我们对链表已合并完成。
 *      如何递归：我们判断 l1 和 l2 头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果。（调用递归）
 *
 *  效率：
 *      O(m+n)  0ms  100%
 *      O(m+n)  37.7MB  93.28%
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
