package com.leetcode.easy;

/**
 * @author Peko
 *  加一
 *      给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *      最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *      你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 解题思路1：
 *      分两种情况，
 *          第一种的正常的情况，就是所有的数都不等于9，这样无论什么总数+1都不会造成数组溢出，
 *      遍历数组如果当前位+1不大于10，则直接返回，否则继续遍历下一位+1
 *          第二种情况是特殊情况，也就是每一位数都是9，这样总数+1就会出现多出一位1在首位，
 *      所以需要重新new一个长度+1的数组，装填结果
 *
 * 效率：
 *      O(N)    0ms     100%
 *      O(N)    36.7MB  89.01%
 *
 * 优化：
 *      对于第二种特殊情况，可以结合到普通情况中，出现特殊情况时，
 *      可以直接对new的数组在首位放1.其余会自动填0
 *
 */
public class Solution66 {

    public int[] plusOne1(int[] digits) {

        int len = digits.length;
        int nightCount = 0;

        for(int d:digits){
            if(d == 9){
                nightCount++;
            }
        }

        if(nightCount == len){
            int[] digitsNew = new int[len+1];
            digitsNew[0] = 1;
            for(int i=1;i<=len;i++){
                digitsNew[i] = 0;
            }
            return digitsNew;
        }

        int sum ;

        for(int i = len-1;i>=0;i--){
            sum = digits[i] + 1;
            digits[i] = sum%10;
            if(sum < 10){
                break;
            }
        }

        return digits;
    }

    public int[] plusOne2(int[] digits) {

        int len = digits.length;

        int sum ;

        for(int i = len-1;i>=0;i--){
            sum = digits[i] + 1;
            digits[i] = sum%10;
            if(sum < 10){
                break;
            }

            if(i == 0){
                int[] digitsNew = new int[len+1];
                digitsNew[0] = 1;
                return digitsNew;
            }
        }

        return digits;
    }

}
