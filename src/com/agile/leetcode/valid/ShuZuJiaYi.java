package com.agile.leetcode.valid;

import java.util.Arrays;

/**
 * 数组最后一位加一进位问题
 */
public class ShuZuJiaYi {
    public static void main(String[] args) {
        int arr[]={9,9,9,8};
        System.out.println(Arrays.toString(arr));
        int[] result = getResult(arr);
        System.out.println(Arrays.toString(result));
    }
    public static int[] getResult(int[] arr){
        for (int i=arr.length-1;i>0;i--){
            arr[i]=arr[i]+1;
            arr[i]=arr[i]%10;
            if (arr[i]!=0){
                return arr;
            }
        }
        //特殊情况，数组中时9999,长度加一，最高位为1，其余默认为0；
        arr=new int[arr.length+1];
        arr[0]=1;
        return arr;
    }
}
