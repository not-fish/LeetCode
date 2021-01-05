package com.leetcode.easy;

/**
 * @author Peko
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 解题思路1：
 *      [摩尔投票法] 以首位数字作为目标数，遍历数组，如果碰到相同的数字则记录+1，否则-1，
 *      当记录数等于0时，改变目标数为当前数字，并且记录数置1
 *
 * 效率：
 *      O(N)     2ms      74.33%
 *      O(1)     41.4 MB  96.38%
 *
 * 优化：
 *      把if(counter > length/2)判断去掉
 * 效率：
 *      O(N)     1ms      99.98%
 *      O(1)     41.4 MB  96.38%
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int target = nums[0];
        int counter = 1;
        int length = nums.length;
        for(int i=1;i<length;i++){

            if(counter > length/2){
                return target;
            }

            if(target == nums[i]){
                counter++;
            }else{
                counter--;
            }

            if(counter == 0) {
                counter = 1;
                target = nums[i];
            }
        }
        return target;
    }
}
