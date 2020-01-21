package com.agile.leetcode.sum;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 数组中元素出现次数超过n/3
 */
public class ChuXianCishu {
    public static void main(String[] args) {
        int[] arr={1,1,1,3,3,3,3,4,2,2,2};
        List<Integer> result = getResult(arr);
        System.out.println(result);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date=new Date();
        date.setTime(1571379664000l);
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        date.setTime(1529632794000l);
        String format1 = simpleDateFormat.format(date);
        System.out.println(format1);
    }
    public static List<Integer> getResult(int[] arr){
        int len=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        int n=(int)Math.floor(len/3);
        for (int i=0;i<len;i++){
                if (map.get(arr[i])!=null){
                    Integer integer = map.get(arr[i]);
                    if (integer+1>n&& !list.contains(arr[i])){
                        list.add(arr[i]);
                    }
                    map.put(arr[i],integer+1);
                }else {
                    map.put(arr[i],1);
                }
            }

        return  list;
    }
}
