package com.agile.leetcode.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数相加接近某个数的经典算法
 */
public class CloseNum {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,8};
        List<Integer> colse = getColse(arr, 88);
        System.out.println("三个最接近的数是"+colse.get(0)+"  "+colse.get(1)+"  "+colse.get(2));
        System.out.println();
        System.out.println("和为"+"  "+colse.get(3));
    }
    private static List<Integer> getColse(int[] arr,int target){
        int ans=arr[0]+arr[1]+arr[2];
        List<Integer> list=new ArrayList<>();
        list.add(0,arr[0]);
        list.add(1,arr[1]);
        list.add(2,arr[2]);
        list.add(3,ans);
        if (arr.length<3){
            return null;
        }
        //排序
        Arrays.sort(arr);
        for (int i=0;i<arr.length;i++){
            int l=i+1;
            int R=arr.length-1;
            while (l<R){
                int sum=arr[i]+arr[l]+arr[R];
                if (Math.abs(sum-target)<Math.abs(ans-target)) {
                    ans=sum;
                    list.add(0,arr[i]);
                    list.add(1,arr[l]);
                    list.add(2,arr[R]);
                    list.add(3,ans);
                }
                if (target>sum){
                    l++;
                }else if (target<sum){
                    R--;
                }else {
                    return list;
                }
            }
        }
        return list;
    }
}
