package com.ghjia.springbootrabbitmq.task;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author ghjia
 * @Date 2019/5/10 14:14
 * @@Version 1.0
 **/
@Component
@RabbitListener(queues = "helloQueue")
public class Consumer {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Consumer1  : " + hello);
    }
}
