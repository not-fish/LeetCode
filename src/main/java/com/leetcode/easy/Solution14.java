package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Peko
 *
 * 寻找字符串组中的最大前缀字符串
 *
 * 解题思路1：
 *      首先计算这些字符串数组中的最短字符串的长度，因为最大前缀肯定不会超过这个长度
 *      循环这个长度，获取字符串组中同一位的字符，然后遍历字符串组对比是否都相等，如果相等则记录
 *
 * 效率：9ms 36.7MB
 *
 * 解题思路2：
 *      字符串A和字符串B两两找出最大前缀，然后把最大前缀作为A，再继续和字符串C比较
 *
 * 注意点：1、如果两两比较出来的结果是""，则直接返回""，后面的不用再比了
 *
 * 效率：1ms 36.1MB
 */
public class Solution14 {
    public String longestCommonPrefix1(String[] strs) {

        int len = strs.length;

        if(len == 0){
            return "";
        }else if(len == 1){
            return strs[0];
        }

        //遍历字符串组的当前个数
        int circle = 0;
        //最大前缀的长度
        int strLen = 0;
        //最短字符串的长度
        int minLen = strs[0].length();
        //最大前缀
        StringBuilder common = new StringBuilder();
        char c = ' ';

        for(String t : strs){
            minLen = Math.min(t.length(),minLen);
        }

        System.out.println("minLen = "+minLen);

        for(int i=0;i<minLen;i++){

            for(String t : strs){
                if(circle == 0){
                    c = t.charAt(strLen);
                    System.out.println("new c = "+c);
                }
                if(c == t.charAt(i)){
                    circle++;
                    System.out.println("c = "+c+"  target = "+t.charAt(i));
                }
            }

            if(circle == len){
                common.append(c);

            }

            circle = 0;
            strLen++;

            if(strLen !=common.length()){
                return common.toString();
            }
        }

        return common.toString();
    }

    public String longestCommonPrefix2(String[] strs) {

        int len = strs.length;

        if(len == 0){
            return "";
        }else if(len == 1){
            return strs[0];
        }

        String maxPrefix = strs[0];
        for(int i=1;i<len;i++){
            maxPrefix = getMaxPrefix(maxPrefix,strs[i]);
            if("".equals(maxPrefix)){
                break;
            }
        }

        return maxPrefix;
    }

    String getMaxPrefix(String str1,String str2){
        int len = Math.min(str1.length(),str2.length());
        int end = 0;
        for(int i=0;i<len;i++){

            if(end != i){
                break;
            }

            if(str1.charAt(i)==str2.charAt(i)){
                end++;
            }
        }

        return str1.substring(0,end);
    }
}
