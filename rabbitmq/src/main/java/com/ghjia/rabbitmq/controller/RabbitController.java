package com.ghjia.rabbitmq.controller;

import com.ghjia.rabbitmq.task.CallBackSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName RabbitController
 * @Description TODO
 * @Author ghjia
 * @Date 2019/5/10 16:40
 * @@Version 1.0
 **/
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Resource
    private CallBackSender callBackSender;

    @PostMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }

}
