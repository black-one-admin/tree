package com.black.one.lambda;

import com.black.one.lambda.functionalInterfaces.Test1;
import com.black.one.lambda.functionalInterfaces.Test2;
import com.black.one.lambda.functionalInterfaces.Test4;

/**
 * 进阶lambda表达式
 *
 * @author swh
 * @create: 2020-08-15 23:01
 */
public class AdvancedLambda {

    public static void main(String[] args) {
        Test1 test1 = () -> {
            System.out.println("lambda表示式精简");
        };
        test1.test();

        Test2 test2 = (a,b) -> {
            System.out.println("lambda表示式精简");
        };
        test2.test2(1,2);

        Test2 test3 = (a ,b) -> System.out.println("只有一句执行语句时可以精简为该形式，无返回值");

        //有返回值的精简
        Test4 test4 = a -> a * a ;
        int test = test4.test(3);


    }
}

