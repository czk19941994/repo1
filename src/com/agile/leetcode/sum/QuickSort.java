package com.agile.leetcode.sum;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 8, 9, 4, 5, 8, 9, 10, 45, 33, 63, 5, 8, 9, 62, 48, 5, 78, 5, 2659, 295, 4, 5};
        //输出原数组
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        //输出排序后的数组
        System.out.println(Arrays.toString(arr));
    }

    //快速排序
    public static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quickSort(low, high, arr);
    }

    private static void quickSort(int low, int high, int[] arr) {
        //循环条件结束
        if (low < high) {
            //分而治之
            int i = patition(low, high, arr);
            //左排序
            quickSort(low, i - 1, arr);
            //右排序
            quickSort(i + 1, high, arr);
        }
    }

    private static int patition(int low, int high, int[] arr) {
        //左指针
        int i = low;
        //右指针
        int j = high;
        //取出第一个坑，一般取数组第一个数据
        int x = arr[i];
        //循环查找
        while (i < j) {
            while (i < j && arr[j] >= x) {
                j--;
            }
            //将数填往第一个坑
            if (i < j && arr[j] <= x) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < x) {
                i++;
            }

            if (i < j && arr[i] >= x) {
                arr[j] = arr[i];
                j--;
            }
        }
        //将第一个数填坑中中间
        arr[i] = x;
        return i;
    }
}
