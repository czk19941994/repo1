package com.agile.leetcode.sum;

/**
 *将一个单词转换为另一个单词最小路径??不懂额
 *
 */
public class DanciZhuanHuan {
    public static void main(String[] args) {
        int i = minDistance("sfsfdfdhelfsalfffsdfsfsfgdgrthukikiddsfso", "sdfssfdfdsfsdfdsfshyjuyd15fsfsffsfsdf");
        System.out.println(i);
    }
    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }
}
