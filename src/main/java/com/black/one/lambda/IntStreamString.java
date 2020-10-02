package com.black.one.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/**
 * 最终操作
 *
 * @author swh
 * @create: 2020-08-19 22:34
 */
public class IntStreamString {


    /**
     * 基础类型，流操作
     * @author swh
     * @date 2020/8/19
     */
    public static void getDataSource(){
        int[] integers = {0,1,2,3,4,5,6,7,8,9,10};
        IntStream stream = Arrays.stream(integers);
        //最终操作
//        int asInt = stream.max().getAsInt();
//        int sum = stream.sum();
//        Double average = stream.average().getAsDouble();

        //流中数据分析
        IntSummaryStatistics intSummaryStatistics = stream.summaryStatistics();
        intSummaryStatistics.getSum();
        intSummaryStatistics.getAverage();
        intSummaryStatistics.getMax();
        intSummaryStatistics.getCount();

    }



}
