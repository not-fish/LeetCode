package com.leetcode.easy;

import java.util.Stack;

public class Solution101 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {

        StringBuffer sum = new StringBuffer();

        function(sum,root);

        System.out.println(sum);
        System.out.println(sum.reverse());

        return sum.toString().equals(sum.reverse().toString());

    }

    public static void function(StringBuffer sum,TreeNode root){
        if(root == null){
            return;
        }

        function(sum,root.left);
        sum.append(root.val);
        function(sum,root.right);
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


