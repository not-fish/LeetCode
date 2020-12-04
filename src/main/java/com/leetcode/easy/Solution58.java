package com.leetcode.easy;

/**
 * @author Peko
 *
 * 最后一个单词的长度
 *
 * 解题思路1：
 *      使用 String.split分割 ' ' 为间隔的字符串，然后返回最后一个不为 "" 的字符串的长度
 *
 * 效率：
 *      O(N)   1ms     38.62%
 *      O(N)   37.2MB  16.54%
 *
 * 解题思路2：
 *      从字符串尾部开始遍历，碰到' '就继续遍历，碰到字符时就记录长度，再碰到' '时就结束，返回长度
 *
 * 效率：
 *      O(N)   0ms      100%
 *      O(1)   36.4MB  97.40%
 */
public class Solution58 {

    public int lengthOfLastWord1(String s) {

        String[] str = s.split(" ");
        for(int i = str.length-1;i>=0;i--){
            if(!"".equals(str[i])){
                return str[i].length();
            }
        }

        return 0;
    }

    public int lengthOfLastWord2(String s) {

        int len = 0;
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                len++;
            }else if(len != 0){
                break;
            }
        }
        return len;
    }
}
