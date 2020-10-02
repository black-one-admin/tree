package com.black.one.lambda.center;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 中间操作
 *
 * @author swh
 * @create: 2020-08-19 23:04
 */
public class ListStream {



    public static void main(String[] args) {
        //filter();
        limitandskip();
        flatMap();
    }

    /**
     * 扁平化映射
     * @author swh
     * @date 2020/8/19
     */
    public static void flatMap(){
        String[] array = {"Hello","world"};
        //将字符串数组中的数据读取到流中
        Stream<String> stream = Arrays.stream(array);
        //需求：统计字符串数组中所有出现的字符
         //stream.map(String::toCharArray).forEach(e-> System.out.println(Arrays.toString(e)));
        stream.map(s -> s.split("")).flatMap(Arrays::stream).forEach(System.out::println);

    }

    /**
     * 元素映射，将流程元素替换为指定元素
     * @author swh
     * @date 2020/8/19
     */
    public static void map(){
        Stream<Student> dataSource = ListStream.getDataSource();
        //获取所有学生的名字，map结束后是一个Stream<Integer>
        List<String> collect = dataSource.map(Student::getName).collect(Collectors.toList());
        //返回IntStrem流
        dataSource.mapToInt(Student::getScore).summaryStatistics();
    }

    /**
     * limit与skip一起使用
     * limit从开头到指定位置
     * skip从指定位置到结尾
     * @author swh
     * @date 2020/8/19
     */
    public static void limitandskip(){
        Stream<Student> dataSource = ListStream.getDataSource();
        dataSource.sorted((s1,s2) -> s1.getAge()-s2.getAge()).limit(10).skip(3).forEach(System.out::println);
    }

    /**
     * 排序
     * @author swh
     * @date 2020/8/19
     */
    public static void sort(){
        Stream<Student> dataSource = ListStream.getDataSource();
        //内置
        dataSource.sorted((s1,s2) -> s1.getAge()-s2.getAge()).forEach(System.out::println);
    }

    public static void distinct(){
        Stream<Student> dataSource = ListStream.getDataSource();
        dataSource.distinct().forEach(System.out::println);
    }


    public static void filter() {
        Stream<Student> dataSource = ListStream.getDataSource();

        dataSource.filter(student -> student.score > 30).forEach(System.out::println);

    }


    public static Stream<Student> getDataSource() {
        ArrayList<Student> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,
                new Student("小明0", 34, 34),
                new Student("小明1", 19, 12),
                new Student("小明2", 12, 45),
                new Student("小明3", 12, 67),
                new Student("小明4", 14, 79),
                new Student("小明5", 35, 4),
                new Student("小明", 34, 34),
                new Student("小明7", 45, 19)
        );
        return arrayList.stream();

    }

    private static class  Student{

        private String name;
        private int age;
        private int score;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age &&
                    score == student.score &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, score);
        }

        public Student(String name, int age, int score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", score=" + score +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
