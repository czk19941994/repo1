package com.agile.leetcode.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 *
 * 示例 2：
 *
 * 输入：[1,1,1]
 * 输出：[false,false,false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZiShuZU {
    public static void main(String[] args) {
        int[] arr={1,1,1,0,1};
        System.out.println(Arrays.toString(arr));
        List<Boolean> result = getResult(arr);
        System.out.println(result);
    }
    public static List<Boolean> getResult(int[] arr){
        List<Boolean> list=new ArrayList<>();
        int len=arr.length;
        String str="";
        for (int i=0;i<len;i++){
            double sum=0;
            int n;
            str+=arr[i];
            for (int j=0,m=str.length()-1;j<str.length();j++,m--){
                sum=sum+Integer.parseInt(str.substring(j,j+1))*Math.pow(2,m);
            }
            n=(int)sum;
            if (n%5==0){
                list.add(Boolean.TRUE);
            }else {
                list.add(Boolean.FALSE);
            }
        }
        return list;
    }
}