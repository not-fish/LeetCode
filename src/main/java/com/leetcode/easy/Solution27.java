package com.leetcode.easy;

/**
 * @author Peko
 *
 * 移除元素(原地)
 * 必须仅使用 O(1) 额外空间并 原地 修改输入数组
 *
 * 解题思路：
 *      用j遍历数组，然后碰到与目标元素相等的值就移动到i位置上，然后i增加，j增加（双索引增加）继续下去
 *
 *效率：
 *      O(N)  0ms  100%
 *      O(1)  36.9MB  84.73%
 *
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
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
