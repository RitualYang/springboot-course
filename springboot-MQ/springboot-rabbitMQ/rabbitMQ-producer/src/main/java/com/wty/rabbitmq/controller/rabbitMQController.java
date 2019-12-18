package com.wty.rabbitmq.controller;

import com.wty.rabbitmq.mq.Producer_topics_springboot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RitualYang
 * @create 2019-10-31 20:30
 */
@RestController
public class rabbitMQController {

    private Producer_topics_springboot producer_topics_springboot;

    //消息队列发送
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void test(){
        producer_topics_springboot.sendEmail();
        producer_topics_springboot.sendPostPage();
    }
}
