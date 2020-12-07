package com.leetcode.easy;

/**
 * @author Peko
 *
 * 实现sqrt
 *      计算并返回 x 的平方根，其中 x 是非负整数。
 *      由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 解题思路1：
 *      如果直接从1遍历到x，会超时，所以使用二分法
 *
 * 效率：
 *      O(logx)   1ms      100%
 *      O(1)      35.5MB   82.76%
 */
public class Solution69 {
    public int mySqrt1(int x) {
        if(x==0){
            return 0;
        }

        if(x==1){
            return 1;
        }

        int left = 1;
        int right = 46341;
        int mid;
        int sum ;

        while(left < right){

            mid = (right-left)/2 + left;
            sum = mid * mid;
            System.out.println(left+" "+right+ " "+sum);
            if(sum < x){
                left = mid +1;
            }else if(sum > x){
                right = mid;
            }else{
                return mid;
            }

        }

        return left-1;

    }
}
