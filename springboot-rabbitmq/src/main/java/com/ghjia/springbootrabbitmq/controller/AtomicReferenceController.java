package com.ghjia.springbootrabbitmq.controller;

import com.alibaba.fastjson.JSONObject;
import com.ghjia.springbootrabbitmq.dto.Person;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName 原子性引用和普通引用
 * @Description TODO
 * @Author ghjia
 * @Date 2019/5/8 14:59
 * @@Version 1.0
 **/
public class AtomicReferenceController {

    // 普通引用
    private static Person person;
    // 原子性引用
    private static AtomicReference<Person> aRperson;

    public static void main(String[] args) throws InterruptedException {
        person = new Person("Tom", 18);
        aRperson = new AtomicReference<Person>(person);

        System.out.println("Atomic Person is " + JSONObject.toJSONString(aRperson.get()));

        Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Now Person is " + person.toString());
    }

    static class Task1 implements Runnable {
        @Override
        public void run() {
            person.setAge(person.getAge() + 1);
            person.setName("Tom1");

            System.out.println("Thread1 Values "
                    + JSONObject.toJSONString(person));
        }
    }

    static class Task2 implements Runnable {
        @Override
        public void run() {
            person.setAge(person.getAge() + 2);
            person.setName("Tom2");

            System.out.println("Thread2 Values "
                    + JSONObject.toJSONString(person));
        }
    }
}
