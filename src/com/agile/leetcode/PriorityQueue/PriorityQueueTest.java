package com.agile.leetcode.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PriorityQueueTest {
    static PriorityQueue<Integer> up = new PriorityQueue<>();
    static PriorityQueue<Integer> down = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {
        addNum(2);
        addNum(1);
        addNum(2);
        addNum(3);
        addNum(3);
        addNum(4);
        System.out.println(findMid());
    }

    public static void addNum(int num) {
        if (up.size() == 0) {
            up.add(num);
            return;
        }
        if (down.size() == 0) {
            if (num < up.peek()) {
                down.add(num);
            } else {
                up.add(num);
                down.add(up.poll());
            }
            return;
        }
        if (up.size() < down.size()) {
            // insert to up
            if (num > down.peek()) {
                // 下大下堆的顶，直接推到上堆
                up.add(num);
            } else {
                down.add(num);
                up.add(down.poll());
            }
        } else {
            // insert to down
            if (num < up.peek()) {
                down.add(num);
            } else {
                up.add(num);
                down.add(up.poll());
            }
        }
    }
    public static double findMid(){
        if (up.size() == down.size()) {
            Integer u = up.peek();
            Integer d = down.peek();
            return (u + d) / 2.0;
        } else {
            return down.peek();
        }
    }
}
