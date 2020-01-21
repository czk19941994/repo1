package com.agile.leetcode.PriorityQueue;

import org.junit.Test;

import java.util.PriorityQueue;
@SuppressWarnings("all")
public class PriorityQueueTest3 {
    //小顶堆->自然顺序
    PriorityQueue<Integer> up=new PriorityQueue<>();
    //大顶堆->大到小
    PriorityQueue<Integer> down=new PriorityQueue<>((o1, o2) -> {
        if (o1-o2>0){
            return -1;
        }
        return 1;
    });
    public void addNum(int i){
        if (up.size()==0) {up.add(i);return;};
        if (down.size()==0) {
            if (i>up.peek()){
                up.add(i);
                down.add(up.poll());
            }else {
                down.add(i);
            }
            return;
        }
        if (up.size()<down.size()){
            if (i>down.peek()){
                up.add(i);
            }else {
                down.add(i);
                up.add(down.poll());
            }

        }else {
            if (i<up.peek()){
               down.add(i);
            }else {
                up.add(i);
                down.add(up.poll());
            }
        }
    }
    public double getMid(){
        if (up.size()==down.size()){
            return (up.peek()+down.peek())/2.0;
        }
        return down.peek();
    }
    @Test
    public void test1(){
        addNum(2);
        addNum(1);
        addNum(2);
        addNum(3);
        addNum(3);
        addNum(4);
        System.out.println(getMid());
    }
}
