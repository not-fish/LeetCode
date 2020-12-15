package com.leetcode.easy;

/**
 * @author Peko
 *
 * 验证回文串
 *      给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *      说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *  解题思路1：
 *      双指针，碰到字母或者数字才进行比较
 *
 *  效率：
 *      O(N)   3ms      93.21%
 *      O(1)   38.6 MB  71.57%
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            left = getLeft(left,s);
            right = getRight(right,s);
            if(!isLetterOrNumber(s.charAt(left)) && !isLetterOrNumber(s.charAt(right))){
                return true;
            }
            int temp = s.charAt(left) - s.charAt(right);
            temp = Math.abs(temp);
            if(temp != 0 && temp != 32){
                return false;
            }

            if(temp == 32){
                if((s.charAt(left) < 65) || (s.charAt(right)<65)){
                    return false;
                }
            }

            left++;
            right--;
        }

        return true;
    }

    private int getRight(int right,String s) {
        while(!isLetterOrNumber(s.charAt(right))){
            if(right <= 0){
                break;
            }
            right--;

        }
        return right;
    }

    private int getLeft(int left,String s) {
        while(!isLetterOrNumber(s.charAt(left))){
            if(left >= s.length()-1){
                break;
            }
            left++;
        }
        return left;
    }

    public boolean isLetterOrNumber(char c){

        if(c >= 48 && c<= 57){
            return true;
        }

        if(c >= 65 && c<= 90){
            return true;
        }

        if(c >= 97 && c<= 122){
            return true;
        }

        return false;
    }
}
