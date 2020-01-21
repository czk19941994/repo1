package com.agile.leetcode.node;

public class TreeTest {
    public static void main(String[] args) {
        Node node4=new Node(4,null,null);
        Node node5=new Node(5,null,null);
        Node node2=new Node(2,node4,node5);
        Node node6=new Node(6,null,null);
        Node node7=new Node(7,null,null);
        Node node3=new Node(3,node6,node7);
        Node node1=new Node(1,node2,node3);
        LinkedTree linkedTree=new LinkedTree(node1);
        //树是否为空
        System.out.println(linkedTree.isEmpty());
        //先续遍历
        linkedTree.preTraverse();
        System.out.println();
        //中序遍历
        linkedTree.interTraverse();
        //后续遍历
        System.out.println();
        linkedTree.postTraverse();
        //树的高度
        System.out.println();
        System.out.println(linkedTree.getHight());
        //节点数
        System.out.println();
        System.out.println(linkedTree.nodeNum());
        //是否存在
        System.out.println();
        System.out.println(linkedTree.isExist(8));
        //查找某个节点
        System.out.println();
        Node byKey = linkedTree.findByKey(2);
        System.out.println(byKey);
        //二叉树的层次遍历
        System.out.println();
        linkedTree.levelByStack();
        //二叉树的非递归中序遍历
        System.out.println();
        linkedTree.inOrderByStack();
    }
}
