package com.black.one.structure;

/**
 * 链表
 * @author swh
 * @create: 2020-10-02 19:04
 */
public class LinkedList<E> implements List<E>{

    private static final int ELEMENT_NOT_FOUND = -1;

    private int size;

    private Node<E> firste;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size,element);
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element,Node<E> next){
            this.element = element;
            this.next = next;
        }
    }
}
