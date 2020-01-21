package com.agile.leetcode.miss;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中缺少的最小正整数
 */
public class MissMaxNum {
    public static void main(String[] args) {
        int[] arr={1,2,0,4,9,2,3,4};
        int num = getNum(arr);
        System.out.println(num);
    }
    public static int getNum(int[] arr){
        //判断数组中是否包含1
        int len=arr.length;
        int contains=0;
        for (int i=0;i<len;i++){
            if (arr[i]==1){
                contains++;
                break;
            }
        }
        if (contains==0){
            return 1;
        }
        //排除arr[1]情况
        if (arr[0]==1&&len==1){
            return 2;
        }
        //将数组中的负数和0以及大于数组长度的数替换为1
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<len;i++){
            if (arr[i]==0||arr[i]>len||arr[i]<0){
                arr[i]=1;
            }
            //集合去重
            set.add(arr[i]);
        }
        //判断是否存在
        for (int i=1;i<=len;i++){
            boolean contains1 = set.contains(i);
            if (contains1) continue;
            return i;
        }
        return -1;
    }
}
