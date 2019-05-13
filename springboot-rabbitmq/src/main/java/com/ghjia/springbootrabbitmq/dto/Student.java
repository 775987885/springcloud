package com.ghjia.springbootrabbitmq.dto;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Description TODO
 * @Author ghjia
 * @Date 2019/5/10 10:04
 * @@Version 1.0
 **/
public class Student implements Serializable {
    private static final long serialVersionUID = 2428218124015764534L;

    private String name;
    private Integer age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
