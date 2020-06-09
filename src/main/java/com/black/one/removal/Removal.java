package com.black.one.removal;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 去重
 *
 * @author swh
 * @create: 2020-06-09 09:56
 */
public class Removal {

    public static void main(String[] args) {
    }

    /**
     *使用list集合去重
     * @params
     * @return
     */
    private static void removeString(List<String> list) {
        Set<String> set = new LinkedHashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        //jdk1.8去重表达式
        list.stream().distinct().collect(Collectors.toList());
    }

    /**
     *根据Person对象的id去重
     * @params
     * @return
     */
    public static List<Person> removeDupliById(List<Person> persons) {
        Set<Person> personSet = new TreeSet<>((o1, o2) -> o1.getId().compareTo(o2.getId()));
        personSet.addAll(persons);
        return new ArrayList<>(personSet);

    }



//    public  List<Person> uniqueById(List<Person> persons) {
//        List<Person> unique = persons.stream().collect(
//                collectingAndThen(toCollection(() -> new TreeSet<>(comparingLong(Person::getId))), ArrayList::new)
//        );
//    }

}

class Person{
    private String id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public  String getId() {
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
