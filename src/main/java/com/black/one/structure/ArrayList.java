package com.black.one.structure;

import java.util.Objects;

/**
 * 数组的定义
 *
 * @author swh
 * @create: 2020-10-02 13:39
 */
public class ArrayList<E> {

    /**
     * 元素数量
     * @author swh
     * @date 2020/10/2
     */
    private int size;

    E[] elements;

    private static final int DEFAULT_CAPACITY =10;

    private static final int ELEMENT_NOT_FOUND =-1;

    public ArrayList(int capaticy){
        capaticy = (capaticy<DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
        elements = (E[])new Objects[capaticy];
    }

    public ArrayList(){
       this(DEFAULT_CAPACITY);
    }




    public int size() {
        return size;
    }

    public boolean empty() {
        return size ==0;
    }

    public boolean contains(E element) {
        return indexOf(element)==-1;
    }

    public void add(E element) {
        add(size,element);
    }

    public E get(int index) {
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
        return elements[index];
    }

    public E set(int index, E element) {
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 某个元素下添加元素
     * @author swh
     * @date 2020/10/2
     */
    public void add( int index,E element){
        if (index<0||index>size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
        ensyreCapacity(index+1);
        for (int i = size; i>= index; i--) {
            elements[i] =elements[i-1];
        }
        elements[index]=element;
        size++;
    }

    /**
     * 移除某个元素
     * @author swh
     * @date 2020/10/2
     */
    public E remove(int index){
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
        E old = elements[index];
        for (int i = index+1; i < size ; i++) {
            elements[i-1] =elements[i];
        }
        elements[--size] = null;
        return old;
    }


    /**
     * 清除所有元素,数组内存不能销毁，能循环利用的留下，不能循环的去掉。
     * 尽量减少性能消耗
     * @author swh
     * @date 2020/10/2
     */
    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        System.gc();
    }


    public int indexOf(E element){
        if (element == null ){
            for (int i = 0; i < size; i++) {
                if(elements[i] == null) return i ;
            }
        }else{
            for (int i = 0; i < size; i++) {
                if(element.equals(elements[i])) return i ;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    private void ensyreCapacity(int capaccity){
        int oldCapacity =elements.length;
        if (oldCapacity>=capaccity)return;
        int newCapacity = oldCapacity+oldCapacity >>1;
        E[] newElements = (E[]) new Objects[newCapacity];
        for (int i=0;i<size;i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}

