package com.leetcode.easy;

/**
 * @author Peko
 *
 * 搜索插入位置
 *      给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *      你可以假设数组中无重复元素。
 *
 * 解题思路1：
 *      直接遍历
 * 效率：
 *      O(N)   1ms      100%
 *      O(1)  38.3MB  58.22%
 *
 * 解题思路2：
 *      二分法
 *
 * 坑：
 *      搜索区间问题
 *      划分 [left, mid] 与 [mid + 1, right] ，mid 被分到左边，对应 int mid = left + (right - left) / 2;
 *      划分 [left, mid - 1] 与 [mid, right] ，mid 被分到右边，对应 int mid = left + (right - left + 1) / 2;
 *
 * 效率：
 *      O(logN)   0ms      100%
 *      O(1)     38.2MB    72.18%
 *
 */
public class Solution35 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,8,9,11,12,13,16,17,18,19,21,23,24,25};
        searchInsert2(nums,20);
    }

    public int searchInsert1(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    public static int searchInsert2(int[] nums, int target) {

        int left = 0;
        int right = nums.length;
        int mid=0,key;

        while(left<right){

            mid = left + (right - left) / 2;
            key = nums[mid];

            if(key > target){
                right = mid;
            }else if(key < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }

        return left;
    }
}
