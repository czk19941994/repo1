package com.agile.leetcode.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和的优秀算法
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeNumSum {
    public static void main(String[] args) {
        int[] arr={1,0,-1,2,0,-2,3,-1,-2};
        List<List<Integer>> threeSum = getThreeSum(arr);
        System.out.println(threeSum);
    }
    public static List<List<Integer>> getThreeSum(int[] arr){
        List<List<Integer>> list=new ArrayList<>();
        int len=arr.length;
        //数组小于三，返回空数组
        if (len<3) return list;
        //排序
        Arrays.sort(arr);
        for (int i=0;i<arr.length;i++) {
            //当i大于零时，就不可能相加为零了
            if (arr[i]>0){
                break;
            }
            //去除重复的开始数字
            if (i>0&&arr[i]==arr[i-1]) continue;
            int L=i+1;
            int R=len-1;
            //循环条件，左指针不能大于右指针
            while (L<R){
                int sum=arr[i]+arr[L]+arr[R];
                if (sum==0){
                    list.add(Arrays.asList(arr[i],arr[L],arr[R]));
                    //去重
                    while (L<R&&arr[L]==arr[L+1]) L++;
                    //去重
                    while (L<R&&arr[R]==arr[R-1]) R--;
                    L++;
                    R--;
                }else if (sum<0){
                    //小于零，向前移动
                    L++;
                }else {
                    //大于零，向后移动
                    R--;
                }
            }
        }
        return list;
    }
}
