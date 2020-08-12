package com.atbit;

/**
 * @author hyc
 * @date 2020/8/12
 **/
public class Duck {
    private String name;
    private int age;
    private Duck next;

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", next=" + next +
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

    public Duck getNext() {
        return next;
    }

    public void setNext(Duck next) {
        this.next = next;
    }
}
