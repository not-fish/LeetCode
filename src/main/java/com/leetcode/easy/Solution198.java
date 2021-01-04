package com.leetcode.easy;

/**
 * @author Peko
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 解题思路1：
 *      动态规划+滚动数组
 *
 *      边界：
 *      dp[0]=nums[0]               只有一间房屋，则偷窃该房屋
 *      dp[1]=max(nums[0],nums[1])  只有两间房屋，选择其中金额较高的房屋进行偷窃
 *
 *      公式：
 *      1、偷窃第 k间房屋，那么就不能偷窃第 k-1间房屋，偷窃总金额为前 k-2间房屋的最高总金额与第k间房屋的金额之和。
 *      2、不偷窃第 k 间房屋，偷窃总金额为前 k-1间房屋的最高总金额。
 *      用 dp[i]表示前 i间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：
 *              dp[i]=max(dp[i−2]+nums[i],dp[i−1])
 *
 *
 * 效率：
 *      O(N)  0ms      100%
 *      O(1)  35.7 MB  73.61%
 */
public class Solution198 {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[dp.length-1];
    }
}
