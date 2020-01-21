package com.agile.leetcode.palindrome;

public class MaxPalindrome {
    public static void main(String[] args) {
        String addaksdahdhaoisdanabbbba = getPalindrome("fbbbbbbbbfbbbfbbbbbbbbbbbfbbbbbbbbbbfbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbba");
        System.out.println(addaksdahdhaoisdanabbbba);
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     *
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str){
        int len=str.length();
        for (int i = 0; i < len/2; i++) {
            if(str.charAt(i)!=str.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
    //暴力破解字符串回文
    public static String getPalindrome(String str){
        long l = System.currentTimeMillis();
        String ans="";
        int max=0;
        int len=str.length();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                String s=str.substring(i,j);
                boolean palindrome = isPalindrome(s);
                if (palindrome){
                    if (s.length()>max){
                        ans=s;
                        max=Math.max(s.length(),max);
                    }
                }
            }
        }
        System.out.println(System.currentTimeMillis()-l);
        return ans;
    }
}
