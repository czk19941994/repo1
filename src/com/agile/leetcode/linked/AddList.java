package com.agile.leetcode.linked;

/**
 * 连接两个有序链表，从小到大
 */
public class AddList {
    public static void main(String[] args) {
        ListNode node5=new ListNode(6,null);
        ListNode node2=new ListNode(2,node5);
        ListNode node1=new ListNode(1,node2);
        ListNode node6=new ListNode(5,null);
        ListNode node4=new ListNode(4,node6);
        ListNode node3=new ListNode(3,node4);
        ListNode solution = solution(node1, node3);
        System.out.println(solution);
    }
    public static ListNode solution(ListNode node1,ListNode node2){
        //哑结点
        ListNode preHead=new ListNode(-1);
        ListNode pre=preHead;
        while (node1!=null&&node2!=null){
            if (node1.data<=node2.data){
                pre.next=node1;
                node1=node1.next;
            }else {
                pre.next=node2;
                node2=node2.next;
            }
            pre=pre.next;
        }
        pre.next=node1==null?node2:node1;
        return preHead.next;
    }
}
