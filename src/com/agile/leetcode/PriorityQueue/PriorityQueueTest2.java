package com.agile.leetcode.PriorityQueue;

import org.junit.Test;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 优先队列的使用
 * 大小堆
 */
public class PriorityQueueTest2 {
    @Test
    public void addNum(){
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((o1, o2) -> {
            if (o1-o2>0){
                return -1;
            }
            return 1;
        });
        //PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(1);
        Iterator<Integer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        for (int i=0;i<3;i++){
            System.out.print(priorityQueue.poll()+" ");
        }
    }

    public void priority(){
        //小顶堆->自然顺序
        PriorityQueue<Integer> up=new PriorityQueue<>();
        //大顶堆->大到小
        PriorityQueue<Integer> down=new PriorityQueue<>((o1, o2) -> {
            if (o1-o2>0){
                return -1;
            }
            return 1;
        });

    }
}
