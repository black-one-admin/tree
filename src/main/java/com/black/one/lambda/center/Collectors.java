package com.black.one.lambda.center;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author swh
 * @create: 2020-08-19 23:53
 */
public class Collectors {


    public static void flatMap(){
        String[] array = {"Hello","world","hihihi"};
        //将字符串数组中的数据读取到流中
        Stream<String> stream = Arrays.stream(array);

        String collect = stream.collect(java.util.stream.Collectors.joining(","));

    }
}
