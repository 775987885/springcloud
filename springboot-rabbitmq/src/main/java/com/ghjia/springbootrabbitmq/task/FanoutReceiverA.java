package com.ghjia.springbootrabbitmq.task;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FanoutReceiverA
 * @Description TODO
 * @Author ghjia
 * @Date 2019/5/10 14:57
 * @@Version 1.0
 **/
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {
    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver A: " + message);
    }
}
