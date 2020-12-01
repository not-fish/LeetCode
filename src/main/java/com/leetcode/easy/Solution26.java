package com.leetcode.easy;

/**
 * @author Peko
 *
 * 删除排序数组中的重复项
 * （必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成）
 *
 * 解题思路1：
 *      遍历数组，将当前数与比较数（前一个数）作比较，如果相等，则不计长度，且数组整体往左移动
 *
 * 效率：
 *      O(n*n)  175ms  5.04%
 *      O(1)    40.2MB   81.66%
 *
 * 解题思路2：
 *      使用双指针的思想，慢指针i与快指针j，j复制遍历数组，i负责记录有效长度
 *      如果 nums[i] == nums[j] ，则跳过，继续遍历
 *      否则 nums[i+1] = nums[j]
 *
 *  效率：
 *      O(n)  1ms  89.05%
 *      O(1)  40.2MB  84.27%
 */
public class Solution26 {
    public int removeDuplicates1(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int temp = nums[0];
        int numsLen = nums.length;
        int len = 1;
        for(int i = 1;i<numsLen;i++){
            if(temp == nums[i]){
                moveNums(i,nums);
                numsLen--;
                i--;
            }else {
                len++;
                temp = nums[i];
            }
        }

        return len;
    }

    public void moveNums(int i,int[] nums){
        for(;i<nums.length;i++){
            nums[i-1] = nums[i];
        }
    }

    public int removeDuplicates2(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int i = 0;
        for(int j = 1;j<nums.length;j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }

}

/**
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len=removeElement(nums,val);

         在函数里修改输入数组对于调用者是可见的。
         根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for(int i=0;i<len; i++){
             print(nums[i]);
        }

 */