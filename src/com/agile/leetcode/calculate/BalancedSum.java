package com.agile.leetcode.calculate;

/**
 * 找出数组左边和等于右边和的索引
 */
public class BalancedSum {
    public static void main(String[] args) {
        int[] arr={1,2,3,5,4,1,8,9,2,5,3,2,6,2,8,5};
        int result = getResult(arr);
        System.out.println(result);
    }
    public static int getResult(int[] arr){
        int len=arr.length;
        int leftSum=0;
        int rightSum=0;
        for (int i=0;i<len;i++){
            rightSum+=arr[i];
        }
        for (int i=0;i<len;i++){
            rightSum=rightSum-arr[i];
            if (leftSum==rightSum) {
                return i;
            }else {
                leftSum+=arr[i];
            }
        }
        return -1;
    }
}
