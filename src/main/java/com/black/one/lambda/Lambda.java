package com.black.one.lambda;

import com.black.one.lambda.functionalInterfaces.Test1;
import com.black.one.lambda.functionalInterfaces.Test2;
import com.black.one.lambda.functionalInterfaces.Test3;

/**
 * lambda表达式编程
 *
 * @author swh
 * @create: 2020-08-15 21:33
 */
public class Lambda {
    public static void main(String[] args) {
        //1.无参无返回值的lambda写法
        Test1 lambda = ()->{
            System.out.println("无参数，无返回值");
        };
        lambda.test();

        //有参无返回值的写法
        Test2 lambda1 = (int a , int b)->{
            System.out.println("这是一个有参，无返回值的lambda表达式："+a*b);
        };
        lambda1.test2(1,2);

        //有参有返回值的表达方式
        Test3 test3 = (int a , int b)->{
            return "这是一个有参，有返回值的lambda表达式："+a*b;
        };
        String s = test3.test3(1, 3);
        System.out.println(s);
    }

}


