package com.agile.leetcode.palindrome;

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
 */
public class PalindromeNum {
    public static void main(String[] args) {
        boolean palindromeNum = isPalindromeNum(1221);
        System.out.println(palindromeNum);
    }
    private static boolean isPalindromeNum(int num){
        if (num<0){
            return false;
        }
        int temp=num;
        int help=1;
        //计算是几位数
        while (temp>=10){
            help*=10;
            temp=temp/10;
        }
        while (num!=0){
            //第一位和最后一位对比
            if (num/help!=num%10){
                return false;
            }
            //截取中间部分
            num = num % help / 10;
            //首尾两个数字，少了两位
            help /= 100;
        }
        return true;
    }
}
