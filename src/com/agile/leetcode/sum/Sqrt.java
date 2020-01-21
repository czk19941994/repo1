package com.agile.leetcode.sum;



/**
 * 利用牛顿迭代法求解一个数的平方根
 */
public class Sqrt {
    static int s;
    public static void main(String[] args) {
        int i = mySqrt(50);
        System.out.println(i);
    }
    public static int mySqrt(int x){
        s=x;
        if (x==0){return x;}
        return (int) getSqrt(x);
    }
    public static double getSqrt(double n){
       double res=(n+s/n)/2;
       if (res==n) {
           return n;
       }else {
           return getSqrt(res);
       }
    }
}
