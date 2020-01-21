package com.agile.leetcode.distence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 数组中并不包含的最小正整数数
 */
public class DisContain {
    public static void main(String[] args) {
        int[] arr={1,5,9,4,6,2,2};
        List<Integer> list = get(arr);
        System.out.println(list);
    }
    private static List<Integer> get(int[] arr){
        HashMap<Integer,Boolean> hashMap=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            hashMap.put(arr[i],true);
        }
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            if (!hashMap.containsKey(i)){
                list.add(i);
            }
        }
        return list;
    }
}
