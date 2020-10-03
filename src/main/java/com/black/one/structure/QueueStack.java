package com.black.one.structure;

import java.util.Stack;
 /**
 * 使用栈实现队列
 * @author swh
 * @create: 2020-10-03 19:03
 */
public class QueueStack<E> {

    private Stack<E> inStack = new Stack<>();
    private Stack<E> outStack = new Stack<>();


    /**
     * 入队
     * @author swh
     * @date 2020/10/3
     */
    public void push(E element){
        inStack.push(element);
    }

    /**
     * 出队
     * @author swh
     * @date 2020/10/3
     */
    public E pop(){
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /**
     * 获取队头元素
     * @author swh
     * @date 2020/10/3
     */
    public E peek(){
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }



    public boolean isEmpty(){
        return inStack.isEmpty()&&outStack.isEmpty();
    }
}
