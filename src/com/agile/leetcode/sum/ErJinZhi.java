package com.agile.leetcode.sum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 两个二进制非空字符串的求和
 */
public class ErJinZhi {
    public static void main(String[] args) {
        String sum = getSum("10101", "10111");
        System.out.println(sum);
        String s = addBinary("10101", "10111");
        System.out.println(s);
    }

    /**
     * 暴力解法，先转为十进制求和在转为二进制
     * @param str1
     * @param str2
     * @return
     */
    public static String getSum(String str1,String str2){
        int sum1=0;
        int sum2=0;
        int len2=str2.length();
        int len1=str1.length();
        for (int i=0,j=str1.length()-1;i<len1;i++,j--){
            sum1+=Integer.parseInt(str1.substring(i,i+1))*Math.pow(2,j);
        }
        for (int i=0,j=str2.length()-1;i<len2;i++,j--){
            sum2+=Integer.parseInt(str2.substring(i,i+1))*Math.pow(2,j);
        }
        int sum=sum1+sum2;
        int t=sum;
        //转换为二进制
        Deque<Integer> deque=new LinkedList();
       do {
            int result=t/2;
            int i=t%2;
            deque.push(i);
            t=result;
       }while (t>0);
       StringBuffer stringBuffer=new StringBuffer();
        while (deque.size()!=0){
           stringBuffer.append(deque.pop());
        }
        return stringBuffer.toString();
    }

    /**
     * leetcode大神的优雅解法
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
