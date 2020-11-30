package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Peko
 *
 * 罗马数字转整数
 *
 * 解题思路1：
 *      从字符串的右边开始两两比较，如果倒数第二位的字符second等级小于倒数第一位的字符first等级，则相减，否则相加
 * 效率：
 *      O(n)  7 ms   40.93%
 *      O(1)  39.1 MB  34.3%
 *
 * 解题思路2：
 *      与解题思路1相同，不过是从左到右，而且把map换成switch
 * 效率：
 *      O(n)  4 ms  99.98%
 *      O(1)  38.7 MB  78.23%
 */
public class Solution13 {
    public int romanToInt1(String s) {

        Map<Character, Integer> valueMaps = new HashMap<Character, Integer>();
        valueMaps.put('I',1);
        valueMaps.put('V',5);
        valueMaps.put('X',10);
        valueMaps.put('L',50);
        valueMaps.put('C',100);
        valueMaps.put('D',500);
        valueMaps.put('M',1000);

        int len = s.length();
        int first,second;
        int sum = valueMaps.get(s.charAt(len-1));

        for(int i=len-1;i>=0;i--){

            first = i;
            second = i-1;
            if(second<0){
                return sum;
            }

            if(valueMaps.get(s.charAt(second))<valueMaps.get(s.charAt(first))){
                sum = sum - valueMaps.get(s.charAt(second));
            }else{
                sum = sum + valueMaps.get(s.charAt(second));
            }
        }

        return sum;
    }

    public int romanToInt2(String s) {

        int len = s.length();
        int sum = 0;
        int preNum = getValue(s.charAt(0));

        for(int i=1;i<s.length();i++){

            int num = getValue(s.charAt(i));

            if(preNum < num){
                sum-=preNum;
            }else{
                sum+=preNum;
            }

            preNum = num;
        }

        sum+=preNum;

        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
