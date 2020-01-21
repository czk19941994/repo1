package com.agile.leetcode.media;

import java.io.*;
import java.security.Provider;
import java.security.SecureRandom;

public class MediaTrunk {
    public static void main(String[] args) throws IOException {
        //trunk();
        //merge();
        double random = Math.random();
        System.out.println(random);
        SecureRandom secureRandom=new SecureRandom(String.valueOf(System.currentTimeMillis()).getBytes());
        Provider provider = secureRandom.getProvider();
        String name = provider.getName();
        System.out.println(name);
    }

    /**
     * 视频的分块
     * @throws IOException
     */
    public static void trunk() throws IOException {
        //视频地址
        String path = "D:\\培训视频\\安全攻击·与防护\\常见共计与防范\\2_47_2_社会工程学.mp4";
        File file = new File(path);
        //InputStream inputStream = new FileInputStream(file);
        RandomAccessFile raf_read=new RandomAccessFile(file,"r");
        //视频大小
        long length = file.length();
        //分块数量
        long ceil = (long) Math.ceil(length * 1.0 / (1024 * 1024 * 1));
        if (ceil < 1) {
            ceil = 1;
        }
        //分块视频存储地址
        String trunkPath = "D:\\czk\\视频";
        //循环读取
        int len = 0;
        RandomAccessFile raf_wirte = null;
        byte[] bytes = new byte[1024];
        for (int i = 0; i < ceil; i++) {
            File file1=new File(trunkPath+"\\"+i+".mp4");
            raf_wirte = new RandomAccessFile(file1,"rw");
            while ((len = raf_read.read(bytes)) != -1) {
                raf_wirte.write(bytes, 0, len);
                if (file1.length()>1024*1024) break;
            }

        }
        raf_wirte.close();
        raf_read.close();
    }

    /**
     * 视频的合并
     * @throws IOException
     */
    public static void merge() throws IOException {
        //分块视频地址
        String trunkPath = "D:\\czk\\视频";
        File file = new File(trunkPath);
        File[] files = file.listFiles();
        int i = files.length;
        RandomAccessFile raf_read = null;
        RandomAccessFile raf_write = new RandomAccessFile(new File("C:\\Users\\李赛飞\\Desktop\\c.mp4"),"rw");
        byte[] bytes = new byte[1024];
        int len = 0;
        for (int j = 0; j < i; j++) {
            trunkPath = trunkPath + "\\" + j+".mp4";
            file = new File(trunkPath);
            raf_read = new RandomAccessFile(file,"r");
            while ((len = raf_read.read(bytes)) != -1) {
                raf_write.write(bytes, 0, len);
            }
            trunkPath="D:\\czk\\视频";
        }
        raf_read.close();
        raf_write.close();
    }
}
