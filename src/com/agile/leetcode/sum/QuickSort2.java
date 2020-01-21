package com.agile.leetcode.sum;

import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr={3,5,9,5,2,5,6,7,1,0};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr){
        int low=0;
        int high=arr.length-1;
        quickSort(low,high,arr);
    }

    private static void quickSort(int low, int high, int[] arr) {
        if (low<high){
            int i=patitinon(low,high,arr);
            quickSort(low,i-1,arr);
            quickSort(i+1,high,arr);
        }
    }

    private static int patitinon(int low, int high, int[] arr) {
        int i=low;
        int j=high;
        int x=arr[i];
        while (i<j){
            while (i<j&&arr[j]>x){
                j--;
            }
            if (i<j&&arr[j]<=x){
                arr[i]=arr[j];
                i++;
            }
            while (i<j&&arr[i]<x){
                i++;
            }
            if (i<j&&arr[i]>=x){
                arr[j]=arr[i];
                j--;
            }
        }
        arr[i]=x;
        return i;
    }
}
