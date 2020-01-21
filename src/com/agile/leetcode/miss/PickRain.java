package com.agile.leetcode.miss;

/**
 * 接雨水问题
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PickRain {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int sUm = getSUm(arr);
        System.out.println(sUm);
    }

    /**
     * 单独计算每列
     * 取出每列的左边和右边元素的最大值，并且每列的值在左边右边最大值的中间
     * min(leftMax,rightMax)-arr[i]的累加即为所接雨水的面积
     *
     * @param arr
     * @return
     */
    public static int getSUm(int[] arr) {
        int len = arr.length;
        int leftMax = 0;
        int rightMaX = 0;
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > leftMax) leftMax = arr[j];
            }
            for (int j = i + 1; j < len; j++) {
                if (arr[j] > rightMaX) rightMaX = arr[j];
            }
            if (arr[i] < leftMax && arr[i] < rightMaX) {
                sum += Math.min(leftMax, rightMaX) - arr[i];
                leftMax = 0;
                rightMaX = 0;
            }
        }
        return sum;
    }
}
