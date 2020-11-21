package com.wty.rabbit.controller;

import com.wty.rabbit.mq.ProducerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author wty
 * @date 2019/10/31 20:30
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitmqController {
    @Autowired
    private ProducerMessage producerMessage;

    @GetMapping("/sendFanoutMessage")
    public String sendFanoutMessage() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("message", "我是好人");
        stringStringHashMap.put("code", "ok");
        producerMessage.sendFanoutMessage(stringStringHashMap);
        return "消息发送成功";
    }

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        producerMessage.sendDirectMessage("spring.boot.amqp", "direct send message");
        return "消息发送成功";
    }

    @GetMapping("/sendFanoutMessage")
    public String sendTopicMessage() {
        producerMessage.sendTopicMessage("kk.boot.hao", "我是测试");
        return "消息发送成功";
    }

}
