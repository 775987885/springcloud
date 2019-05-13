package com.ghjia.springbootrabbitmq.controller;


import com.ghjia.springbootrabbitmq.task.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RabbitTest
 * @Description TODO
 * @Author ghjia
 * @Date 2019/5/10 14:14
 * @@Version 1.0
 **/
@RestController
@RequestMapping("/rabbit")
public class RabbitTest {
    @Autowired
    private Producer producer1;
    @Autowired
    private Producer producer2;

    /**
     * result:
     * producer1 : hello1 Fri May 10 15:05:18 CST 2019
     * Consumer1  : hello1 Fri May 10 15:05:18 CST 2019
     */
    @PostMapping("/hello")
    public void hello() {
        producer1.send();
    }

    /**
     * 交替出现
     * result:
     * producer1 : hello1 Fri May 10 15:05:18 CST 2019
     * Consumer1  : hello1 Fri May 10 15:05:18 CST 2019
     *
     * producer1 : hello1 Fri May 10 15:05:18 CST 2019
     * Consumer2  : hello1 Fri May 10 15:05:18 CST 2019
     */
    @PostMapping("/oneToMany")
    public void oneToMany() {
        producer1.send();
    }


    /**
     * fanout路由规则：接受发送到该exchange(type=fanout) 的消息，路由到所有与他绑定的queue中
     * result:
     * fanout producer1 : hi, fanout msg
     * fanout Receiver A: hi, fanout msg
     * fanout Receiver B: hi, fanout msg
     * fanout Receiver C: hi, fanout msg
     */
    @PostMapping("/fanout")
    public void fanout(){
        producer1.fanoutSend();
    }

    @PostMapping("/topic")
    public void topic(){
        producer1.topicSend();
    }
}
