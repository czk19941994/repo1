package com.agile.leetcode.test;

import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;


public class StackTest {
    public static void main(String[] args) {
        BigInteger n = new BigInteger("78187957727044802278826145448");
        BigInteger t = n;
        Deque stack = new LinkedList<Integer>();
        long l = System.currentTimeMillis();
        do {
            BigInteger result = t.divide(new BigInteger("2"));
            BigInteger i = t.mod(new BigInteger("2"));
            stack.push(i);
            t = result;

        } while (t.intValue()>0);
        long i=System.currentTimeMillis()-l;
        System.out.println(i);
        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
    }
}
