package com.agile.leetcode.sum;



/**
 * 设有n楼梯，每次可以爬1阶或两阶，则一共有多少中方法
 * 动态规划方案
 * 到达第n阶的方法数等于第（n-1）阶和（n-2）阶之和，如此推算
 */
public class PaLouTi {
    public static void main(String[] args) {
        int count = getCount(30);
        System.out.println(count);
        int count1 = getCount1(30);
        System.out.println(count1);
        int count2 = getCount2(30);
        System.out.println(count2);

    }
    public static int getCount(int n){
        if (n==1) return n;
        //因为要取第n阶，不然要数组越界
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++){
            dp[i]=dp[i-2]+dp[i-2];
        }
        return dp[n];
    }
    // 扩展，每次可以走 1,2,3，步
    public static int getCount1(int n){
        if (n==1) return 1;
        if (n==2) return 2;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for (int i=4;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
    public static int getCount2(int n){
        if (n==1) return 1;
        if (n==2) return 2;
        if (n==3) return 3;
        if (n==4) return 4;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        dp[4]=6;
        for (int i=5;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4];
        }
        return dp[n];
    }
}
