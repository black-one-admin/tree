package com.black.one.structure;


import java.util.ArrayList;
import java.util.List;

/**
 * 栈
 *
 * @author swh
 * @create: 2020-10-03 17:09
 */
public class Stack<E> {

    private List<E> list = new ArrayList<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(E element){
        list.add(element);
    }

    public E pop(){
     return list.remove(list.size()-1);
    }

    public E top(){
        return list.get(list.size()-1);
    }



}
