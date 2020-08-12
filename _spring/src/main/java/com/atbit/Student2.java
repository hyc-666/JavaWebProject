package com.atbit;

/**
 * @author hyc
 * @date 2020/8/10
 **/
public class Student2 {
    private String name;
    private int age;


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

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}