package com.black.one.structure;

import java.util.Objects;

/**
 * 循环队列
 *
 * @author swh
 * @create: 2020-10-03 19:36
 */
public class CircleQueue<E> {
    /**
     * 头
     * @author swh
     * @date 2020/10/3
     */
    private int front;

    private int size;

    private E[] elements;

    private static final int DEFAULT_CAPACITY =10;


    public CircleQueue(){
        elements =(E[]) new Objects[DEFAULT_CAPACITY];
    }


    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void enQueue(E element){
        ensyreCapacity(size+1);
        elements[(size+front)%elements.length] = element;
        size++;
    }

    public E deQueue(){
        E frontElement = elements[front];
        elements[front] = null;
        front = (size+1)%elements.length;
        size--;
        return frontElement;
    }

    public E front(){
        return elements[front];
    }

    private void ensyreCapacity(int capaccity){
        int oldCapacity =elements.length;
        if (oldCapacity>=capaccity)return;
        int newCapacity = oldCapacity+oldCapacity >>1;
        E[] newElements = (E[]) new Objects[newCapacity];
        for (int i=0;i<size;i++){
            newElements[i] = elements[(i+front)%elements.length];
        }
        elements = newElements;
        front = 0;
    }
}


