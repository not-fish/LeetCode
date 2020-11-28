package com.leetcode.easy;

import java.util.Stack;

/**
 * @author Peko
 *
 * 括号匹配
 *
 * 解题思路1：
 *      遍历字符串，对于左括号，就入栈，对于右括号就查是否与栈顶匹配，如果匹配则栈顶出栈，否则返回不匹配
 *
 * 效率：
 *      2ms  75.85%
 *      36.5MB  82.69%
 *
 * 把栈改写成数字，速度会快一点
 */
public class Solution20 {
    public static void main(String[] args) {
        System.out.println(isValid("{[{]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        int len = s.length();

        for(int i = 0;i<len;i++){

            if(stack.size()>len-i){
                return false;
            }

            char c = s.charAt(i);
            if(!isRight(c)){
                stack.push(c);
            }else if(stack.empty()){
                return false;
            }else{
                char temp = getLeft(c);
                char left = stack.peek();
                if(temp == left){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static boolean isRight(char c){
        return c == ')' || c == '}' || c == ']';
    }

    public static char getLeft(char c){
        switch(c){
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
        }

        return ' ';
    }


}
