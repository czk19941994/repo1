package com.agile.leetcode.sum;

/**
 * 数组中，两个数的和减去两个之间的距离最大值
 */
public class MaxDistence {
    public static void main(String[] args) {
        int[] arr={8,1,5,2,6,2};
        int result = getResult(arr);
        System.out.println(result);
    }
    //暴力解法
    private static int getResult(int[] arr){
        if (arr==null||arr.length==0){
            return 0;
        }
        int len=arr.length;
        int max=0;
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                int max1 = Math.max(max, arr[i] + arr[j] + i - j);
                if (max1>max){
                    max=max1;
                }
            }
        }
        return max;
    }
}
