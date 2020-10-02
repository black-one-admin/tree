package com.black.one.lambda;

/**
 * lambda表达式对象方法特殊引用
 *
 * @author swh
 * @create: 2020-08-19 22:00
 */
public class Lambda3 {


    private static class Person{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    @FunctionalInterface
    private interface  MyInerface{
        String get(Person person);
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("xiao");
        MyInerface myInerface = Person::getName;
        System.out.println(myInerface.get(person));
    }
}
