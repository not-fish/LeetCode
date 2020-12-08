package com.leetcode.easy;


/**
 * @author Peko
 *
 * 爬楼梯
 *      每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
 *
 * 解题思路1：
 *      爬到 n 阶楼相当于从 n-1 阶爬上来，或者从 n-2 阶爬上来的
 *      直接递归会报栈，所以用动态规划
 *
 * 效率：
 *      O(N)   0ms      100%
 *      O(1)   35.4 MB  44.88%
 */
public class Solution70 {
    public int climbStairs(int n) {

        if(n <= 2){
            return n;
        }

        int[] nums = new int[n+1];
        nums[1] = 1;
        nums[2] = 2;
        for(int i = 3;i<=n;i++){
            nums[i] = nums[i-1] + nums[i-2];
        }

        return nums[n];
    }
}
