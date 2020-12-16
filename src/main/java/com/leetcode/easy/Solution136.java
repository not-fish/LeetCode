package com.leetcode.easy;

import java.util.Arrays;

/**
 * @author Peko
 * 只出现一次的数字
 *      不用额外的空间
 *
 * 解题思路1：
 *      先给数组排序，然后一位位地对比，如果出现不相等地两位数，则把前一位返回
 *
 * 效率：
 *      O(NlogN)   6ms     31.32%
 *      O(1)   38.4MB  93.26%
 *
 * 解题思路2：
 *      1)异或运算，任何数和 0 做异或运算，结果仍然是原来的数，即 a ^ 0 = a ⊕ 0 = a
 *      2)任何数和其自身做异或运算，结果是 0，即 a ^ a = a ⊕ a = 0 
 *      3)异或运算满足交换律和结合律，即 a ^ b ^ a = b ^ a ^ a = b ^ (a ^ a)=b ^0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
 *
 * 效率：
 *      O(N)   1ms     99.1%
 *      O(1)   38.5MB  84.07%
 */
public class Solution136 {
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int temp = nums[0];
        for(int i = 1;i< nums.length;i+=2){

            if(temp != nums[i]){
                break;
            }

            temp = nums[i+1];
        }

        return temp;
    }

    public int singleNumber2(int[] nums) {

        int ans = nums[0];

        for(int i = 1;i<nums.length;i++){
            ans = ans ^ nums[i];
        }

        return ans;
    }
}
