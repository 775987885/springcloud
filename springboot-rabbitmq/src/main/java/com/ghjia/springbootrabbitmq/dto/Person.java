package com.ghjia.springbootrabbitmq.dto;

import java.io.Serializable;

/**
 * @ClassName Person
 * @Description TODO
 * @Author ghjia
 * @Date 2019/5/8 15:07
 * @@Version 1.0
 **/
public class Person implements Serializable{

    private static final long serialVersionUID = 6803513317978233135L;
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
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
}
