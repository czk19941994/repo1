package com.agile.leetcode.miss;

/**
 * 给定一个数，判断是否为3的n次幂
 */
public class NciMi {
    public static void main(String[] args) {
        boolean n = isN(7);
        System.out.println(n);
    }

    public static boolean isN(int n) {
        if (n < 1) return false;
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }
}
