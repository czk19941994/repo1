package com.agile.leetcode.AESandRSA;

import java.io.UnsupportedEncodingException;

public class BinaryStringConverteUtil {
    private static final String BIN_SEPARATOR=" ";

    /**
     * 普通字符串转换为二进制字符串
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String toBinaryString(String str) throws UnsupportedEncodingException {
        if (str==null) return null;
        byte[] bytes = str.getBytes();
        StringBuffer stringBuffer=new StringBuffer();
        for (byte aByte : bytes) {
            stringBuffer.append(Integer.toBinaryString(aByte)+BIN_SEPARATOR);
        }
        return stringBuffer.toString();
    }
    public static String toString(String binaryString){
        if (binaryString==null) return null;
        String[] s = binaryString.split(BIN_SEPARATOR);
        StringBuffer stringBuffer=new StringBuffer();
        for (String s1 : s) {
            char c=binstrToChar(s1);
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
    /**
     * 将二进制转换成字符
     * @param binStr 二进制字符串
     * @return char
     * @Auth zongf
     * @Date 2019-05-07
     */
    private static char binstrToChar(String binStr){
        int[] temp=binstrToIntArray(binStr);
        int sum=0;
        for(int i=0; i<temp.length;i++){
            sum +=temp[temp.length-1-i]<<i;
        }
        return (char)sum;
    }

    /**
     * 二进制字符转换为int数组
     * @param binStr 二进制字符串
     * @return int[]
     * @Auth zongf
     * @Date 2019-05-07
     */
    private static int[] binstrToIntArray(String binStr) {
        char[] temp=binStr.toCharArray();
        int[] result=new int[temp.length-1];
        for(int i=0;i<temp.length;i++) {
            result[i]=temp[i]-48;
        }
        return result;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String bianry = toBianry("严");
        System.out.println(bianry);
        String string = toBinaryString("严");
        System.out.println(string);
        String string1 = toString(string);
        System.out.println(string1);
    }
    public static String toBianry(String str){
        if (str==null) return null;
        char[] chars = str.toCharArray();
        StringBuffer stringBuffer=new StringBuffer();
        for (char aChar : chars) {
            stringBuffer.append(Integer.toBinaryString(aChar)+BIN_SEPARATOR);
        }
        return stringBuffer.toString();
    }
}
