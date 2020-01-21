package com.agile.leetcode.processbuider;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestProcess {
    public static void main(String[] args) throws IOException {
        //此类用于创建操作系统进程，它提供一种启动和管理进程（也就是应用程序）的方法。
        ProcessBuilder processBuilder=new ProcessBuilder();
        //设置命令
        processBuilder.command("javac");
        //将错误输出流合并
        processBuilder.redirectErrorStream(true);
        //开启一个进程
        Process process = processBuilder.start();
        //得到进出进程输出流
        InputStream inputStream = process.getInputStream();
        //将字节流转为字符流
        char[] chars=new char[1024];
        int len=-1;
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"GBK");
        while ((len=inputStreamReader.read(chars))!=-1){
            String s=new String(chars,0,len);
            System.out.println(s);
        }
        inputStream.close();
        inputStreamReader.close();
    }
}
