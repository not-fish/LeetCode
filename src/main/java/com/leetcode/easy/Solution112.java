package com.leetcode.easy;

/**
 * @author Peko
 * 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 解题思路1:
 *      递归，从根节点开始，sum减去当前节点的值，然后同时往左右节点遍历
 *      如果碰到了叶子，则判断当前节点的值是否等于sum，如果等于则意味着路径存在
 *      如果碰到空节点，则直接返回false
 *
 * 效率：
 *      O(N)     0ms       100%
 *      O(N)     38.4 MB   74.24%
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            return sum == root.val;
        }

        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
}
