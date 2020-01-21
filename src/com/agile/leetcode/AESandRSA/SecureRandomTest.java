package com.agile.leetcode.AESandRSA;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class SecureRandomTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        //指定算法 支持NativePRNG和SHA1PRNG。两种算法
        SecureRandom secureRandom=SecureRandom.getInstance("SHA1PRNG");
        SecureRandom secureRandom1=new SecureRandom();
        System.out.println(secureRandom1.nextInt(10));
        int i = secureRandom.nextInt(10);
        //
        byte[] bytes=new byte[50];
        //获得一个长度固定的随机数组
        secureRandom.nextBytes(bytes);
        Arrays.sort(bytes);
        System.out.println(Arrays.toString(bytes));
        System.out.println(i);
    }
}
