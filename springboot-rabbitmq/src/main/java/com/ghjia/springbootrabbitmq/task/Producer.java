package com.ghjia.springbootrabbitmq.task;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName Productor
 * @Description TODO
 * @Author ghjia
 * @Date 2019/5/10 14:12
 * @@Version 1.0
 **/
@Component
public class Producer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMsg = "hello1 " + new Date();
        System.out.println("producer1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }

    public void fanoutSend(){
        String context = "hi, fanout msg ";
        System.out.println("fanout producer1 : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);

    }

    public void topicSend() {
        String msg1 = "I am topic.mesaage msg======";
        System.out.println("sender1 : " + msg1);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", msg1);

        String msg2 = "I am topic.mesaages msg########";
        System.out.println("sender2 : " + msg2);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", msg2);
    }

}
