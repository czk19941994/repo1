package com.agile.leetcode.node;

/**
 * 二叉树节点
 */
public class Node {
    Object data;
    Node leftNode;
    Node rightNode;

    public Node(Object data, Node leftNode, Node rightNode) {
        super();
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    public Node(){};

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
