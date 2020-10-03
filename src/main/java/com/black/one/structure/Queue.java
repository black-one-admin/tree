package com.black.one.structure;

import java.util.LinkedList;
import java.util.List;

/**
 * 队列
 *
 * @author swh
 * @create: 2020-10-03 18:48
 */
public class Queue<E> {


    private List<E> list = new LinkedList<>();


    public int size(){
        return  list.size();
    }

    /**
     * 是否为空
     * @author swh
     * @date 2020/10/3
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * 入队
     * @author swh
     * @date 2020/10/3
     */
    public void enQueue(E element){
        list.add(element);
    }

    /**
     * 出队
     * @author swh
     * @date 2020/10/3
     */
    public E deQueue(){
        return  list.remove(0);
    }

    /**
     * 获取队列的头元素
     * @author swh
     * @date 2020/10/3
     */
    public E front(){
        return list.get(0);
    }

    /**
     * 清空队列
     * @author swh.
     * @date 2020/10/3
     */
    public void clear(){
        list.clear();
    }

}
