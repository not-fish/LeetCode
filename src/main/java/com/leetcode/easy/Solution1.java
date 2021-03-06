package com.leetcode.easy;


/**
 * @author Peko
 *
 * 找出两数之和
 *
 *  解题思路：
 *      循环数组，以当前数看作是num1，然后用target减去num1，得到num2
 *      循环剩下的数组的数，找是否有等同num2的，如果有则返回两个数的下标
 *
 *  坑：
 *      1、小心负数情况，如果target为数组，则将target和数组里面的数都转正
 *
 *  效率：
 *      O(n*n)  0ms    100%
 *      O(1)  38.4MB   89.10%
 */
class Solution1 {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        int numOne,numTow;
        int len = nums.length;

        if(target < 0){
            target*=-1;
            for(int i =0;i<nums.length;i++){
                nums[i]*=-1;
            }
        }

        for(int i = 0;i<len;i++){

            numOne = nums[i];
            numTow = target - numOne;
            for(int j = i+1;j<len;j++){
                //找出与num2等同的数
                if(nums[j]==numTow){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
