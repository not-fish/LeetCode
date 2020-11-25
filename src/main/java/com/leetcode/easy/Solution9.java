package com.leetcode.easy;

/**
 * @author Peko
 * 回文整数
 *
 * 解题思路1：
 *      把目标数截为左右两半，然后计算右边的回文数是否等于左边
 * 效率：52 ms 39 MB
 *
 * 解题思路2：
 *  *    直接从目标数尾部算起回文
 *  * 效率：9 ms 37.9 MB
 */
public class Solution9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome2(120000021));
    }
    public static boolean isPalindrome1(int x) {

        if(x<0){
            return false;
        }else if(x%10==0 && x!=0){
            return false;
        }

        int len = conutNum(x);
        int leftNum;
        if(len%2==0){
            leftNum = x / (int)Math.pow(10,len/2);
        }else{
            leftNum = x / (int)Math.pow(10,(len/2)+1);
        }

        int rightNum = x % (int)Math.pow(10,len/2);

        if(conutNum(leftNum)!=conutNum(rightNum)){
            leftNum = deleteZero(leftNum);
        }

        System.out.println("leftNum = "+leftNum+" "+"rightNum = "+rightNum);
        int sum = func(rightNum);
        if(leftNum == sum){
            return true;
        }

        return false;
    }

    private static int deleteZero(int leftNum) {
        while(leftNum%10==0){
            leftNum/=10;
        }

        return leftNum;
    }

    public static int conutNum(int x){
        int count = 0;
        while(x>0){
            x/=10;
            count++;
        }
        return count;
    }

    public static int func(int n){
        int pop = 0;
        int temp = 0;
        while(n>0){
            pop = n%10;
            temp = temp*10+pop;
            n/=10;
        }
        return temp;
    }

    public static boolean isPalindrome2(int x) {
        if(x<0){
            return false;
        }else if(x%10==0 && x!=0){
            return false;
        }

        int pop = 0;
        int temp = 0;
        while(temp < x){
            pop = x%10;
            temp = temp*10+pop;
            x/=10;
        }

        return x==temp || x==(temp/10);
    }
}
