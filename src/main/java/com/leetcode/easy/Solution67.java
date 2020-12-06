package com.leetcode.easy;

/**
 * @author Peko
 *
 * 二进制求和
 *
 * 解题思路1：
 *      将两个字符串都弄成同样长度，长度不够的补0，然后再给两个字符串首位补一个0，放置首位进位
 *      然后直接等位计算，并且加上进位
 *
 * 效率：
 *      O(N+M)  3ms      57.86%
 *      O(N)    38.3 MB  36.94%
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder aBuilder = new StringBuilder(a);
        StringBuilder bBuilder = new StringBuilder(b);

        if("0".equals(a) && "0".equals(b)){
            return "0";
        }

        if(a.length() != b.length()){
            int maxLen = Math.max(a.length(),b.length());
            int zeroNum;
            if(a.length() - maxLen !=0){
                zeroNum = maxLen - a.length();

                while(zeroNum-- > 0){
                    aBuilder.insert(0, "0");
                }
            }else{
                zeroNum = maxLen - b.length();

                while(zeroNum-- > 0){
                    bBuilder.insert(0, "0");
                }
            }
        }
        aBuilder.insert(0, "0");
        bBuilder.insert(0, "0");
        a = aBuilder.toString();
        b = bBuilder.toString();
        int carry = 0;
        StringBuilder sum = new StringBuilder();
        for(int i=a.length()-1;i>=0;i--){
            int temp = a.charAt(i) + b.charAt(i) + carry - 48;
            if(temp == '0'){
                sum.insert(0,'0');
                carry = 0;
            }else if(temp == '1'){
                sum.insert(0,'1');
                carry = 0;
            }else if(temp == '2'){
                sum.insert(0,'0');
                carry = 1;
            }else{
                sum.insert(0,'1');
                carry = 1;
            }
        }

        if(sum.charAt(0) == '0'){
            return sum.toString().substring(1);
        }

        return sum.toString();
    }
}
