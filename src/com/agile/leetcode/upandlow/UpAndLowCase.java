package com.agile.leetcode.upandlow;

import java.util.HashSet;

import java.util.Set;

/**
 * 字符转换大小写
 */
@SuppressWarnings("all")
public class UpAndLowCase {
    public static void main(String[] args) {
        Set<String> a1b2 = getResult2("a1bcd4mddos5f415fdsf8rtb2");
        System.out.println(a1b2.size());
        System.out.println(a1b2);
    }

    /**
     * 每次只有一个字符转换
     * @param str
     * @return
     */
    public static Set<String> getResult(String str){
        Set<String> set=new HashSet<>();
        int len=str.length();
        for (int i=0;i<len;i++){
            char c = str.charAt(i);
            if (Character.isLowerCase(c)){
                if (i==1){
                    String s=str.substring(i,i+1);
                    String s1=str.substring(i+1);
                    set.add(s.toUpperCase()+s1);
                    continue;
                }
                String s=str.substring(i,i+1);
                String s1=str.substring(0,i);
                String s2=str.substring(i+1);
                set.add(s1+s.toUpperCase()+s2);
            }
            if (Character.isUpperCase(c)){
                if (i==1){
                    String s=str.substring(i,i+1);
                    String s1=str.substring(i+1);
                    set.add(s.toLowerCase()+s1);
                    continue;
                }
                String s=str.substring(i,i+1);
                String s1=str.substring(0,i);
                String s2=str.substring(i+1);
                set.add(s1+s.toLowerCase()+s2);
            }

        }
        return set;
    }

    /**
     * 后面是字母就变换
     * @param str
     * @return
     */
    public static Set<String> getResult2(String str){
        Set<String> set=new HashSet<>();
        int len=str.length();
        for (int i=0;i<len-1;i++){
            if (!Character.isUpperCase(str.charAt(i))&&!Character.isLowerCase(str.charAt(i))) continue;
            String substring1 = str.substring(0, i);
            String substring = str.substring(i, i + 1);
            String substring2 = str.substring(i + 1);
            set.add(substring1+substring.toUpperCase()+substring2);
            set.add(substring1+substring.toLowerCase()+substring2);
            for (int j=i+1;j<len;j++){

                if (Character.isLowerCase(str.charAt(j))||Character.isUpperCase(str.charAt(j))) {
                    String substring3 = str.substring(i + 1, j);
                    String substring4 = str.substring(j, j + 1);
                    String substring5 = str.substring(j + 1);
                    set.add(substring1+substring.toLowerCase()+substring3+substring4.toLowerCase()+substring5);
                    set.add(substring1+substring.toLowerCase()+substring3+substring4.toUpperCase()+substring5);
                    set.add(substring1+substring.toUpperCase()+substring3+substring4.toLowerCase()+substring5);
                    set.add(substring1+substring.toUpperCase()+substring3+substring4.toUpperCase()+substring5);
                }
            }
        }
        return set;
    }
}
