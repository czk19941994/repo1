package com.agile.leetcode.node;

import java.util.*;

public class LinkedTree implements NodeInterface {
    private Node root;

    @Override
    public void preTraverse() {
        /**
         * 先续遍历
         */
        this.preTraverse(root);
    }

    private void preTraverse(Node node) {
        if (node != null) {
            //根节点
            System.out.print(node.data + "  ");
            //左节点
            this.preTraverse(node.leftNode);
            //右节点
            this.preTraverse(node.rightNode);
        }
    }

    /**
     * 中序遍历
     */
    @Override
    public void interTraverse() {
        this.interTraverse(root);
    }

    private void interTraverse(Node node) {
        if (node != null) {
            //左节点
            this.interTraverse(node.leftNode);
            //跟节点
            System.out.print(node.data + "  ");
            //右节点
            this.interTraverse(node.rightNode);
        }
    }

    /**
     * 后续遍历
     */
    @Override
    public void postTraverse() {
        this.postTraverse(root);
    }

    private void postTraverse(Node node) {
        if (node != null) {
            //左节点
            this.postTraverse(node.leftNode);
            //右节点
            this.postTraverse(node.rightNode);
            // 根节点
            System.out.print(node.data + "  ");
        }

    }

    /**
     * 树的高度
     */

    @Override
    public int getHight() {
        return this.getHight(root);
    }

    private int getHight(Node node) {
        if (node == null) {
            return 0;
        }
        //左子树高度
        int lh = this.getHight(node.leftNode);
        //右子树高度
        int rh = this.getHight(node.rightNode);
        return lh > rh ? lh + 1 : rh + 1;
    }

    /**
     * 节点数
     */

    @Override
    public int nodeNum() {
        this.nodeNum(root);
        return list.size();
    }



    private void nodeNum(Node node) {
        if (node != null) {
            list.add(node.data);
            this.nodeNum(node.leftNode);
            this.nodeNum(node.rightNode);
        }
    }

    public LinkedTree(Node root) {
        this.root = root;
        this.initList(root);
    }

    /**
     *  初始化list
     * @param root
     */
    private void initList(Node root){
        if (root!=null){
            list.add(root.data);
            this.initList(root.leftNode);
            this.initList(root.rightNode);
        }
    }


    /**
     * 是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 查找某一节点是否存在
     *
     * @param object
     * @return
     */
    @Override
    public boolean isExist(Object object) {
        return this.isExist(root, object);
    }

    @Override
    public Node findByKey(Object value) {
        return this.findByKey(root,value);
    }
    List<Node> nodeList=new ArrayList<>();
    private void addNode(Node node){
        if (node!=null){
            nodeList.add(node);
            this.addNode(node.leftNode);
            this.addNode(node.rightNode);
        }
    }
    private Node findByKey(Node node,Object object){
        //递归查找
        if (node==null){
            return null;
        }else if (node!=null&&node.data.equals(object)){
            return node;
        }else {
            Node node1=this.findByKey(node.leftNode,object);
            Node node2=this.findByKey(node.rightNode,object);
            if (node1!=null&&node1.data.equals(object)){
                return node1;
            }
            if (node2!=null&&node2.data.equals(object)){
                return node2;
            }
        }
        return null;
        //非递归查找
      //return findByKeyList(node,object);
    }

    /**
     *
     * @param node
     * @return
     */
    private Node findByKeyList(Node node,Object object){
        this.addNode(node);
        for (Node node1 : nodeList) {
            if (node1.data.equals(object)&&node1!=null){
                return node1;
            }
        }
        return null;
    }
    private boolean isExist(Node node, Object object) {
        this.nodeNum(node);
        boolean contains = list.contains(object);
        return contains;
    }

    /**
     * 中序遍历，借助栈
     */

    @Override
    public void inOrderByStack() {
       if (root!=null){
           Node current=root;
           Deque<Node> deque=new LinkedList<>();
           while (current!=null||!deque.isEmpty()){
               while (current!=null){
                   deque.push(current);
                   current=current.leftNode;
               }
               if (!deque.isEmpty()){
                   current= deque.pop();
                   System.out.print(current.data);
                   current=current.rightNode;
               }
           }
       }
    }
    /**
     * 层次遍历，借助队列
     */
    @Override
    public void levelByStack() {
        if(root!=null){
            //创建队列
            Queue<Node> queue=new LinkedList<>();
            //跟节点放入队列中
            queue.add(root);
            while (queue.size()!=0){
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    Node poll = queue.poll();
                    System.out.print(poll.data);
                    if (poll.leftNode!=null){queue.add(poll.leftNode);}
                    if (poll.rightNode!=null){queue.add(poll.rightNode);}
                }
            }
        }
        return;
    }
    //返回最小的节点
    public Object next(){
        list.sort((o1, o2) -> {
            if ((Integer)o1-(Integer) o2>0){
                return 1;
            }
            return -1;
        });
        Object object=list.get(0);
        list.remove(0);
        return object;
    }
    //
    public boolean hasnext(){
        return list.size()==0?false:true;
    }
}