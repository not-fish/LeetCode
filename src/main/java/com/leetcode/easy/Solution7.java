package com.leetcode.easy;

/**
 * @author Peko
 *
 * 整数反转
 *
 * 解题思路1：
 *     把整数转为字符串，然后for循环，从下标0开始与最大下标的数进行转换，两头往中间靠
 * 效率：
 *      2 ms  33.84%
 *      O(1)  35.2 MB 97.22%
 * 坑：小心溢出，捕获并返回0
 *
 * 解题思路2：
 *     一位位地构建
 * 效率：
 *      1 ms     100%
 *      O(1)  35.8 MB  62.43%
 */
class Solution7 {
    public int reverse1(int x) {

        boolean isNegative = false;

        if(x<10 && x>(-10)){
            return x;
        }

        if(x<0){
            x*=(-1);
            isNegative = true;
        }

        while(x%10==0){
            x/=10;
        }

        String xStr = Integer.toString(x);
        char[] chars = xStr.toCharArray();

        for(int i=0,j=chars.length-1;i<j;i++,j--){
            swap(chars,i,j);
        }

        xStr = new String(chars);
        try{
            x = Integer.parseInt(xStr);
        }catch(Exception e){
            return 0;
        }

        if(isNegative){
            x*=(-1);
        }

        return x;
    }

    public static void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public int reverse2(int x) {

        boolean isNegative = false;

        if(x<10 && x>(-10)){
            return x;
        }

        if(x<0){
            x*=(-1);
            isNegative = true;
        }

        while(x%10==0){
            x/=10;
        }

        int pop = 0;
        int temp = 0;

        while(x>0){

            if(temp > 214748364){
                return 0;
            }

            pop = x%10;
            x=x/10;

            temp = temp*10;
            temp +=pop;


        }

        if(isNegative){
            temp*=(-1);
        }

        return temp;
    }
}
