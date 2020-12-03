package com.leetcode.easy;

/**
 * @author Peko
 *
 * 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 解题思路1：
 *      动态规划，遍历数组，首先假设nums[0]为最大和max
 *      然后从下标1开始，每一位数都与本身加上前一位数的和作比较，然后留下最大者，并且对比max
 *      公式：
 *          nums[i] = Math.max(nums[i], (nums[i] + nums[i - 1]));
 *          max = Math.max(max, nums[i]);
 *
 * 效率：
 *      O(N)  1ms     94.20%
 *      O(1)  38.6MB  53.86%
 *
 * 优化：
 *      把前一个数的结果放进一个变量pre中，而不是数组中
 *
 * 效率：
 *      O(N)   0ms   100%
 *      O(1)  38.6MB  53.86%
 */
public class Solution53 {

    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] = Math.max(nums[i], (nums[i] + nums[i - 1]));
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for(int i=0;i<nums.length;i++){
            pre = Math.max(nums[i], (nums[i] + pre));
            max = Math.max(max, pre);
        }

        return max;
    }
}
