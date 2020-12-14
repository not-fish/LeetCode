package com.leetcode.easy;

/**
 * @author Peko
 * 二叉树的最大深度
 *
 * 解题思路：
 *      递归遍历整棵树，比较左子树与右子树的节点数量，返回最大值
 *
 * 效率：
 *      O(N)     0ms      100%
 *      O(N)     38.3 MB  84.26%
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftConut = maxDepth(root.left);
        int rightCount = maxDepth(root.right);

        return Math.max(leftConut, rightCount)+1;
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
}
