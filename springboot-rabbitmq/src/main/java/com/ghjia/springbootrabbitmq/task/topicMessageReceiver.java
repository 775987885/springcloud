package com.ghjia.springbootrabbitmq.task;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName topicMessageReceiver
 * @Description TODO
 * @Author ghjia
 * @Date 2019/5/10 16:11
 * @@Version 1.0
 **/
@Component
@RabbitListener(queues = "topic.message")
public class topicMessageReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessageReceiver  : " +msg);
    }
}
