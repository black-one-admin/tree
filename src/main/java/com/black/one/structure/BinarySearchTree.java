package com.black.one.structure;

import java.util.Comparator;

/**
 * 二叉树
 *
 * @author swh
 * @create: 2020-10-03 21:23
 */
public class BinarySearchTree<E>{

    private int size;

    private Node<E> root;

    private Comparator<E> comparator;

    public BinarySearchTree(){
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    void clear(){}

    void add(E element){
        elementNotNullCheck(element);

        if (root == null ){
            root = new Node<>(element,null);
            size++;
            return;
        }

        //添加的不是第一个节点
        //找到父节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp =0;
        while (node != null) {
             cmp = compare(element, node.element);
            parent =node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                return;
            }
        }

        Node<E> newNOde = new Node<>(element,parent);
        if (cmp>0){
            parent.right =newNOde;
        }else {
            parent.left = newNOde;
        }
        size++;
    }

    /**
     * element,跟各个节点之间的比较
     * @author swh
     * @date 2020/10/3
     */
    private int compare(E e1,E e2){
        if (comparator != null){
            return comparator.compare(e2, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    void remove(){}

    boolean contains(E element){
        return false;
    }


    private void elementNotNullCheck(E element){
        if (element == null ){
            throw new IllegalArgumentException("element must not be null");
        }
    }


    private static class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

}
