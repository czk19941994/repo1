package com.agile.leetcode.distence;

import java.util.Stack;

/**
 * 给定一个数，转成二进制后查找两个1之间的最长距离
 */
public class MaxDis {
    public static void main(String[] args) {
        tansEr(1058080000);
    }

    private static int getDistence(int n) {
        //转为二进制
        String s = tansEr(n);

        return 1;
    }

    private static String tansEr(int n) {
        Stack<Integer> stack = new Stack();
        int m;
        do {
            int i = n % 2;
            m = n / 2;
            n = m;
            stack.push(i);
        } while (m != 0);
        StringBuffer stringBuffer = new StringBuffer();
        int j=0;
        int index=0;
        //距离
        int d=0;
        while (!stack.isEmpty()) {
            int c=stack.pop();
            if (c==1){
               int b=j-index;
               if (b>d){
                   d=b;
               }
               index=j;
            }
            stringBuffer.append(c);
            j++;
        }
        System.out.println(stringBuffer.toString());
        System.out.println(d);
        return stringBuffer.toString();
    }
}
