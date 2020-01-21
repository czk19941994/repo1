package com.agile.leetcode.recursive;

import java.io.File;

public class FileSize {
    public static void main(String[] args) {
        Long fileSize = getFileSize(new File("D:\\6 风险评估总结"));
        System.out.println(fileSize);
    }
    public static Long getFileSize(File file){
        long sum=0;
        if (file.isFile()){
            return 0l;
        }
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()){
                sum=sum+file1.length();
            }else {
                sum=sum+getFileSize(file1);
            }
        }
        return sum;
    }
}
