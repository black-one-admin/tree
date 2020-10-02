package com.black.one.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 最终操作
 *
 * @author swh
 * @create: 2020-08-19 22:34
 */
public class IntStream {


    /**
     * 基础类型，流操作
     * @author swh
     * @date 2020/8/19
     */
    public static Stream<Integer> getDataSource(){
        Integer[] integers = {0,1,2,3,4,5,6,7,8,9,10};
        return Arrays.stream(integers);
    }


    public static void max(){
        
    }
}
