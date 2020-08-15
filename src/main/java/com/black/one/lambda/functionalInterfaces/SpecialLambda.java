package com.black.one.lambda.functionalInterfaces;

/**
 * 特殊lambda表达式的引用
 * 使用lambda表达式需要注意局部变量与全局变量的区别
 * @author swh
 * @create: 2020-08-15 23:59
 */
public class SpecialLambda {

    public static void main(String[] args) {
        //使用lambda表达式是为了获取对象的名称 peron就是一个对象 peron.getName就是方法体可以引用person类中的方法
        Get get = peron -> peron.getName();
        Get get1 = Person::getName;

        //给对象设置值
        Set set = (peron,name)-> peron.setName(name);
        Set set1 = Person::setName;

    }


}
@FunctionalInterface
interface Get{
    void get(Person person);
}

@FunctionalInterface
interface Set{
    void set(Person person,String name);
}

class Person{
    private String name;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
