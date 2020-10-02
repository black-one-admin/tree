package com.black.one.lambda.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 最终操作
 *
 * @author swh
 * @create: 2020-08-16 00:54
 */
public class FinalOperation {

    /**
     * 最终操作，整个到一个新的集合
     * @author swh
     * @date 2020/8/16
     */
    public static void collectUsage(){
        Stream<Integer> dataSource = getDataSource();
        //List<Integer> collect = dataSource.collect(Collectors.toList());
        Map<String, Integer> collect = dataSource.collect(Collectors.toMap(Object::toString, integer -> integer));
    }

    /**
     * 指定规则 ,都是最终的流
     * @author swh
     * @date 2020/8/16
     */
    public static void matching(){
        Stream<Integer> dataSource = getDataSource();
        //都满足该规则 且
        boolean b = dataSource.allMatch(el -> el > 50);
        //或
        boolean c = dataSource.anyMatch(el -> el > 50);
        //非 且
        boolean d = dataSource.noneMatch(el -> el > 50);
    }

    /**
     * 最终操作比较大小
     * @author swh
     * @date 2020/8/19
     */
    public static void max(){
        Stream<Integer> dataSource = getDataSource();
        Optional<Integer> max = dataSource.max(Integer::compareTo);
    }

    /**
     * 查找最终操作
     * @author swh
     * @date 2020/8/16
     */
    public static void find(){
        Stream<Integer> dataSource = getDataSource();
        Optional<Integer> first = dataSource.findFirst();
        if (first.isPresent()){
            Integer integer = first.get();
        }
        //获取人员元素
        Optional<Integer> any = dataSource.findAny();
    }

    //流中reduce方法两个比较,最终操作
    public static void reduce(){
        Stream<Integer> dataSource = getDataSource();
        //dataSource.reduce((p1,p2)->p1+p2); 先同
        Integer integer = dataSource.reduce(Integer::sum).get();
    }
    //最终操作count
    public static void count(){
        Stream<Integer> dataSource = getDataSource();

        long integer = dataSource.count();
    }

    public static void forEach(){
        Stream<Integer> dataSource = getDataSource();
        dataSource.forEach(System.out::println);
    }
    
    public static Stream<Integer> getDataSource(){
        List<Integer> list = new ArrayList<>();
        //填充元素
        Collections.addAll(list,0,1,2,3,4,5,6,7,8,9,10);
        return list.stream();
    }
}
