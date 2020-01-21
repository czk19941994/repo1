package com.agile.leetcode.vacabularyNum;

import java.util.ArrayList;
import java.util.List;

public class VacabularyNum {
    public static void main(String[] args) {

    }

    public static int getResult(String str, String[] arr) {
        List<String> list = new ArrayList<>();
        if (arr.length == 0) return -1;
        int len = arr.length;
        int strlen = str.length();
        for (int i = 0; i < len; i++) {
            if (arr[i].length() > str.length()) continue;
            if (str.contains(arr[i])) {
                list.add(arr[i]);
                continue;
            }

                for (int m=0;m<arr[i].length();m++){
                    for (int j = 0; j < strlen; j++) {
                        if (arr[i].substring(i, i + 1).equals(str.substring(j, j + 1))) {

                        }
                    }
            }
        }

        return list.size();
    }
}
