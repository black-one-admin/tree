package com.black.one.structure;

/**
 * @author swh
 * @create: 2020-10-02 19:14
 */
public interface List<E> {
     int size();

     boolean empty() ;

     boolean contains(E element);


     void add(E element);

     E get(int index);

     E set(int index, E element);

    /**
     * 某个元素下添加元素
     * @author swh
     * @date 2020/10/2
     */
     void add( int index,E element);

    /**
     * 移除某个元素
     * @author swh
     * @date 2020/10/2
     */
     E remove(int index);



    /**
     * 清除所有元素,数组内存不能销毁，能循环利用的留下，不能循环的去掉。
     * 尽量减少性能消耗
     * @author swh
     * @date 2020/10/2
     */
     void clear();


     int indexOf(E element);


}
