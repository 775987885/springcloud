package com.ghjia.rabbitmq.task;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @ClassName CallBackSender
 * @Description TODO
 * @Author ghjia
 * @Date 2019/5/10 16:42
 * @@Version 1.0
 **/
@Component
public class CallBackSender implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplatenew;

    public void send() {
        rabbitTemplatenew.setConfirmCallback(this);
        String msg="callbackSender : i am callback sender";
        System.out.println(msg );
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("callbackSender UUID: " + correlationData.getId());
        this.rabbitTemplatenew.convertAndSend("exchange", "topic.messages", msg, correlationData);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        // TODO Auto-generated method stub
        System.out.println("callbakck confirm: " + correlationData.getId());
    }
}
