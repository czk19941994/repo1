package com.agile.leetcode.node;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树API接口的定义
 */
public interface NodeInterface {
    List<Object> list = new ArrayList<>();
    /**
     * 先序遍历
     */
    void preTraverse();
    /**
     * 中序遍历
     */
    void interTraverse();
    /**
     * 后续遍历
     */
    void postTraverse();
    /**
     * 树的高度
     */
    int getHight();
    /**
     * 节点数
     */
    int nodeNum();
    /**
     * 是否为空
     */
    boolean isEmpty();

    /**
     *判断节点是否存在
     * @param object
     * @return
     */
    boolean isExist(Object object);

    /**
     * 查找某个节点
     * @param value
     * @return
     */
    Node findByKey(Object value);
    /**
     * 非递归的的层次遍历，借助队列
     */
    void inOrderByStack();
    /**
     * 非递归中序遍历，借助栈
     */
    void levelByStack();
}
