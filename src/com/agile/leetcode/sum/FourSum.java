package com.agile.leetcode.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四个数之和接近target
 */
public class FourSum  {
    public static void main(String[] args) {
        int[] arr={1,5,9,5,9,8,6,0,1,3,-2,-8,-1,6,-5,4,3,5,2,8};
        List<List<Integer>> sum = getSum(arr, 15);
        System.out.println(sum);
    }
    public static List<List<Integer>> getSum(int[] arr,int target){
        List<List<Integer>> list=new ArrayList<>();
        if (arr.length<4){
            return list;
        }
        Arrays.sort(arr);
        //固定两个数
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                int l=j+1;
                int R=arr.length-1;
                //排除重复固定元素
                if (i>0&&arr[i]==arr[i-1]) continue;
                if (j>0&&arr[j]==arr[j-1]) continue;
                //两数之和大于后后面就不可能等于了
                if (arr[i]+arr[j]>target) break;
                while (l<R){
                    //排除重复指针元素
                    while (l<R&&arr[l]==arr[l+1]) l++;
                    while (l<R&&arr[R]==arr[R-1]) R--;
                    int sum=arr[i]+arr[j]+arr[l]+arr[R];
                    if (sum==target){
                        list.add(Arrays.asList(arr[i],arr[j],arr[l],arr[R]));
                        l++;
                        R--;
                    }else if (sum>target){
                        R--;
                    }else {
                        l++;
                    }
                }
            }
        }
        return list;
    }
}
