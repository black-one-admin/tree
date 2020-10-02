package com.black.one.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流stream数据源的获取
 *
 * @author swh
 * @create: 2020-08-16 00:35
 */
public class DataSource {

    public static void main(String[] args) {

    }

    public static void collectionDataSource(){

        List<Integer> list = new ArrayList<>();
        //填充元素
        Collections.addAll(list,0,1,2,3,4,5,6,7,8,9,10);
        //读取集合中的元素，将其读取到流中,同步流
        Stream<Integer> stream = list.stream();
        //并发流
        Stream<Integer> integerStream = list.parallelStream();
        System.out.println(stream);

    }


    public static void arrayDataSource(){
        Integer[] integers = {1,2,3,4,5};
        Stream<Integer> stream = Arrays.stream(integers);

        int[] ints = {1,2,3,4,5};
        IntStream stream1 = Arrays.stream(ints);
    }

}
