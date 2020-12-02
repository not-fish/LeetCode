package com.leetcode.easy;

/**
 * @author Peko
 *
 * 实现 strStr()
 *
 * 解题思路1：
 *      用i遍历haystack，逐位与needle比较，如果比较长度j与needle相等则返回i，若不相等则i增加，继续与needle逐位比较
 *
 * 效率：
 *      O(N*M)   1ms     74.14%
 *      O(1)     37.2MB  73.89%
 *
 * 解题思路2：
 *      使用 String.indexOf()
 *
 * 效率：
 *      0ms     100%
 *      36.8MB  97.36%
 *
 * 解题思路3：
 *      KMP，劝退，辛苦学会了又忘系列
 */
public class Solution28 {

    public int strStr1(String haystack, String needle) {

        if(haystack.length() <= needle.length()){
            if(haystack.equals(needle)){
                return 0;
            }else{
                return -1;
            }
        }

        if("".equals(needle)){
            return 0;
        }

        int len = needle.length();
        int j = 0;

        for(int i = 0;i<haystack.length();i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                for(j = 1;j<len;j++){
                    if(i+j >= haystack.length() || haystack.charAt(i+j) != needle.charAt(j)){
                        break;
                    }
                }

                if(j==len){
                    return i;
                }else{
                    j = 0;
                }
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

}
