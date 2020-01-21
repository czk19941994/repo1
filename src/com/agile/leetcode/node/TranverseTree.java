package com.agile.leetcode.node;

/**
 * 翻转二叉树，将左右节点交换
 */
public class TranverseTree {
    public static void main(String[] args) {
        //创建二叉树
        Node node1=new Node(1,null,null);
        Node node3=new Node(3,null,null);
        Node node6=new Node(6,null,null);
        Node node9=new Node(9,null,null);
        Node node2=new Node(2,node1,node3);
        Node node7=new Node(7,node6,node9);
        Node root=new Node(4,node2,node7);
        tanverse(root);
        post(root);
        //
        LinkedTree linkedTree=new LinkedTree(root);

        System.out.println("分割线");
        while (linkedTree.hasnext()){
            System.out.print(linkedTree.next()+"  ");
        }

    }
    public static void post(Node root){
        if (root!=null){
            System.out.println(root.data);
            post(root.leftNode);
            post(root.rightNode);
        }
    }

    /**
     * 翻转二叉树
     * @param root
     */
    public static void tanverse(Node root){
        if (root!=null){
            if (root.leftNode!=null&&root.rightNode!=null){
                Node node=new Node();
                node=root.rightNode;
                root.rightNode=root.leftNode;
                root.leftNode=node;
                tanverse(root.rightNode);
                tanverse(root.leftNode);
            }
        }
    }


}
