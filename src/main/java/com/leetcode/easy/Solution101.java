package com.leetcode.easy;

import java.util.Stack;

/**
 * @author Peko
 *
 * 给定一个二叉树，检查它是否是镜像对称的
 *
 * 解题思路：
 *      把二叉树分为两个子树，然后双指针遍历两个子树，
 *      必须是当前节点值相等，而且左右节点的值也相等才算是对称的
 *      p指针走左边时，q指针走右边，p指针走右边时，q指针走左边
 *
 * 效率：
 *      O(N)   0ms      100%
 *      O(N)   36.6 MB  63.42%
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {

        return check(root,root);

    }

    public boolean check(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


