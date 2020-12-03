package com.leetcode.easy;

/**
 * @author Peko
 *
 * 外观数列
 *      给定一个正整数 n ，输出外观数列的第 n 项。
 *     「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *     · countAndSay(1) = "1"
 *     · countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *
 * 解题思路1：
 *      直接遍历，从 n = 1开始
 *
 * 效率
 *      22ms  14.92%
 *      24MB  12.73%
 *
 * 优化：
 *      把String换成StringBuilder
 *
 * 效率：
 *      2ms     75.13%
 *      36.3MB  43.65%
 */
public class Solution38 {
    public String countAndSay(int n) {

        String casS = "1";

        for(int i=1;i<n;i++){
            casS = numToString2(casS);
        }

        return casS;
    }

    public String numToString1(String casS){
        char c = casS.charAt(0);
        int num = 1;
        int i = 1;
        StringBuilder result = new StringBuilder();
        for(;i<casS.length();i++){
            if(c == casS.charAt(i)){
                num++;
            }else{
                result.append(num).append(casS.charAt(i - 1));
                c = casS.charAt(i);
                num = 1;
            }
        }

        result.append(num).append(casS.charAt(i - 1));

        return result.toString();
    }

    public String numToString2(String casS){
        char c = casS.charAt(0);
        int num = 1;
        int i = 1;
        StringBuilder result = new StringBuilder();
        for(;i<casS.length();i++){
            if(c == casS.charAt(i)){
                num++;
            }else{
                result.append(num).append(casS.charAt(i - 1));
                c = casS.charAt(i);
                num = 1;
            }
        }

        result.append(num).append(casS.charAt(i - 1));

        return result.toString();
    }
}
