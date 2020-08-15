package com.black.one.lambda.functionalInterfaces;

/**
 * lambda表示式中函数引用
 *
 * @author swh
 * @create: 2020-08-15 23:30
 */
public class Lambda1 {

    public static int calculate(int a ,int b ){
        if (a>b){
            return a-b;
        }else if (b>a){
            return b-a;
        }
        return a+b;
    }

    public  int cal(int a ,int b ){
        if (a != b){
            return a-b;
        }
        return a+b;
    }

    public static void main(String[] args) {
        //lambda表达式引用Lambda1类中的静态方法calculate(int a ,int b )
        //注意事项：参数与返回值需要一致，引用类方法需要为静态方法
        Calculate calculate = Lambda1::calculate;
        int cal = calculate.cal(12, 13);
        //两者是一致的
        Calculate calculate1 = (x,y) ->calculate(x,y);
        int cal1 = calculate1.cal(12, 13);

        //引用非静态方法 ，需要先new一个对象
        Calculate calobject = new Lambda1()::cal;
    }

}
@FunctionalInterface
 interface Calculate{
    int cal(int a ,int b);
}
