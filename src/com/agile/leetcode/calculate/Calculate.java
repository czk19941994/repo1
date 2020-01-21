package com.agile.leetcode.calculate;

import java.util.Stack;

/**
 * 实现四则运算
 */
public class Calculate {
    public static void main(String[] args) {

    }
    private static int getResult(String str){
        //String[] fuhao={"+","-","*","/"};
        //数字栈
        Stack<Integer> integerStack=new Stack<>();
        //符号栈
        Stack<String> stringStack=new Stack<>();
        int len=str.length();
        for (int i=0;i<len;i++){
            if (i==0){
                String s=str.substring(i,i+1);
                //压入数字栈
                integerStack.push(Integer.parseInt(s));
                continue;
            }
            String s=str.substring(i,i+1);
            if (s.equals("*")||s.equals("/")){
            }

        }
        return 1;
    }

}
