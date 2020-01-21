package com.agile.leetcode.linked;

public class ListNode {
    Integer data;
    ListNode next;

    public ListNode(Integer data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
