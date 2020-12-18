package com.leetcode.easy;

/**
 * @author Peko
 *
 * 买卖股票的最佳时机
 *      给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *      如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *      注意：你不能在买入股票前卖出股票。
 *
 * 解题思路1：
 *      双指针，一个用来记录买的价格，一个用来记录卖的价格
 *      如果只有两个数的情况下，那么第一天只能买入，第二天只能卖出，所以初始化时，第一天为买，第二天为卖，然后从第二天开始遍历
 *      如果当天的价格小于记录的买入价格，则将当天的价格记为买入价格（同时也记为卖出的价格，因为把当天记为买入之后，只能在该天往后卖出）
 *      如果当天的价格大于记录的卖出价格，则将当天的价格记为卖出价格
 *      每次遍历都计算出利润，然后对比记录的利润值，记下最大利润
 *      遍历完成之后，看最大利润有没有大于0，如果大于0则返回，否则返回0
 *
 * 效率：
 *      O(N)     1ms      98.85%
 *      O(1)     37.9 MB  95.85%
 */
public class Solution121 {

    public int maxProfit(int[] prices) {

        if(prices.length <= 1){
            return 0;
        }

        int buy = prices[0];
        int sale = prices[1];
        int max = sale - buy;

        for(int i = 1;i<prices.length;i++){

            if(buy > prices[i]){
                buy = prices[i];

                sale = buy;
            }

            if(sale < prices[i]){
                sale = prices[i];
            }

            if(sale - buy > max){
                max = sale - buy;
            }
        }

        return Math.max(max, 0);
    }
}
