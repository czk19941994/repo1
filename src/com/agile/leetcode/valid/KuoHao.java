package com.agile.leetcode.valid;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成三对有效括号数的算法
 */
public class KuoHao {
    public static void main(String[] args) {
        int n = 4;
        List<String> generate = generateParenthesis(3);
        System.out.println(generate.size());
        System.out.println(generate);
    }

    public static List<String> generate(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backTrack(List<String> ans, String str, int i, int j, int n) {
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }
        if (i < j) {
            backTrack(ans, str + "(", i + 1, j, n);

        }
        if (i > j) {
            backTrack(ans, str + ")", i, j + 1, n);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

}
