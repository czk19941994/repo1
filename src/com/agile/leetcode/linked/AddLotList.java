package com.agile.leetcode.linked;


import java.util.Arrays;

/**
 * 提供两种组合方法
 * 合并多个有序链表,两个链表合并（首位链表的合并时间复杂度小,但是会改变传入数组的值
 */
public class AddLotList {
    public static void main(String[] args) {
        //第一个
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        //第二个
        ListNode node6 = new ListNode(89, null);
        ListNode node5 = new ListNode(56, node6);
        ListNode node4 = new ListNode(3, node5);
        //第三个
        ListNode node9 = new ListNode(9, null);
        ListNode node8 = new ListNode(8, node9);
        ListNode node7 = new ListNode(7, node8);
        //第四个
        ListNode node12 = new ListNode(18, null);
        ListNode node11 = new ListNode(11, node12);
        ListNode node10 = new ListNode(10, node11);
        ListNode[] listNodes = {node1, node4, node7, node10};
        ListNode sum = getSum1(listNodes);
        System.out.println(sum);
        System.out.println(Arrays.toString(listNodes));
    }

    public static ListNode getSum(ListNode[] listNodes) {
        int len = listNodes.length;
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (listNodes[0] != null && listNodes[1] != null) {
            if (listNodes[0].data <= listNodes[1].data) {
                pre.next = listNodes[0];
                listNodes[0] = listNodes[0].next;
            } else {
                pre.next = listNodes[1];
                listNodes[1] = listNodes[1].next;
            }
            pre = pre.next;
        }
        pre.next = listNodes[0] == null ? listNodes[1] : listNodes[0];
        pre = preHead.next;
        for (int i = 2; i < len; i++) {
            ListNode preHead1 = new ListNode(-1);
            ListNode pre1 = preHead1;
            while (listNodes[i] != null && pre != null) {
                if (pre.data <= listNodes[i].data) {
                    pre1.next = pre;
                    pre = pre.next;
                } else {
                    pre1.next = listNodes[i];
                    listNodes[i] = listNodes[i].next;
                }
                pre1 = pre1.next;
            }
            pre1.next = pre == null ? listNodes[i] : pre;
            pre = preHead.next;
        }
        return preHead.next;
    }

    public static ListNode getSum1(ListNode[] listNodes) {
        int len = listNodes.length;
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                listNodes[i] = mergeTwoLink(listNodes[i], listNodes[len - 1 - i]);
            }
            len = (len + 1) / 2;
        }
        return listNodes[0];
    }

    private static ListNode mergeTwoLink(ListNode node1, ListNode node2) {
        //哑结点
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (node1 != null && node2 != null) {
            if (node1.data <= node2.data) {
                pre.next = node1;
                node1 = node1.next;
            } else {
                pre.next = node2;
                node2 = node2.next;
            }
            pre = pre.next;
        }
        pre.next = node1 == null ? node2 : node1;
        return preHead.next;
    }
}
