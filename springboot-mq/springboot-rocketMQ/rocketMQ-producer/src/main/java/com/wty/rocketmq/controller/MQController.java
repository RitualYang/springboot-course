package com.wty.rocketmq.controller;

import com.wty.rocketmq.service.RocketmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MQController {

    @Autowired
    private RocketmqService rocketmqService;

    public String send() {
        rocketmqService.send("test", "hello world!!!");
        return "消息发送成功。。。";
    }
}
