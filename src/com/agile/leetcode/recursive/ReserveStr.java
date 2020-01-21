package com.agile.leetcode.recursive;

public class ReserveStr {
    public static void main(String[] args) {
        String abcde = reserve("abcde");
        System.out.println(abcde);
    }
    public static String reserve(String str){
        if (str.length()==1){
            return  str;
        }
       return reserve(str.substring(1))+str.substring(0,1);
    }
}
