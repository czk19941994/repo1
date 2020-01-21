package com.agile.leetcode.trangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形得最短路径
 * 自定向下
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LessDistence {
    public static void main(String[] args) {
        List<Integer> list1=new ArrayList<>();
        list1.add(2);
        List<Integer> list2=new ArrayList<>();
        list2.add(3);list2.add(4);
        List<Integer> list3=new ArrayList<>();
        list3.add(6);list3.add(5);list3.add(7);
        List<Integer> list4=new ArrayList<>();
        list4.add(4);list4.add(1);list4.add(8);list4.add(3);
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(list1);lists.add(list2);lists.add(list3);lists.add(list4);
        int result = getResult(lists);
        System.out.println(result);
    }

    /**
     * 自下而上的方法、、有点难理解
     * @param list
     * @return
     */
    public static int getResult(List<List<Integer>> list){
        int size = list.size();
        int[] arr=new int[size+1];
        for (int level=size-1;level>=0;level--){
            for (int i=0;i<=level;i++){
                //max则是最大路径，min则是最小路径
                arr[i]=Math.max(arr[i],arr[i+1])+list.get(level).get(i);
            }
        }
        return arr[0];
    }
}
