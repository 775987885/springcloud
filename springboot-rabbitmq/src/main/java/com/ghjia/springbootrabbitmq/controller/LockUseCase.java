package com.ghjia.springbootrabbitmq.controller;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockUseCase
 * @Description java并发包中与锁相关的API和组件
 * @Author ghjia
 * @Date 2019/5/9 16:23
 * @@Version 1.0
 **/
public class LockUseCase {

    public void test() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try

        {
        } finally

        {
            lock.unlock();
        }
    }


}
