package com.leetcode.easy;


/**
 * @author Peko
 * 相同的树
 *      给定两个二叉树，编写一个函数来检验它们是否相同。
 *      如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 解题思路：
 *      遍历整棵树，首先比较当前节点的值，然后再比较左节点，然后是右节点
 *      两棵树必须是左右两边节点都是相等才算是相同树
 *
 *  效率：
 *      O(N)  0ms      100%
 *      O(1)  36.1 MB  47.96%
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null || q == null){
            return p == q;
        }

        if(p.val != q.val){
            return false;
        }

        boolean b1 = isSameTree(p.left,q.left);
        boolean b2 = isSameTree(p.right,q.right);

        return b1 && b2;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
