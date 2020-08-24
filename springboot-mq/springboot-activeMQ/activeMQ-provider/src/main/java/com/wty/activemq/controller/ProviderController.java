package com.wty.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@RestController
public class ProviderController {

    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    //注入springboot封装的工具类
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping(value = "sendQueue",method = RequestMethod.GET)
    public String sendQueue(String name) {
        //方法一：添加消息到消息队列
        jmsMessagingTemplate.convertAndSend(queue, name);
        //方法二：这种方式不需要手动创建queue,系统会自行创建名为test的队列
        //jmsMessagingTemplate.convertAndSend("test", name);
        return "queue 发送成功";
    }

    @RequestMapping(value = "sendTopic",method = RequestMethod.GET)
    public String sendTopic(String name) {
        //方法一：添加消息到消息队列
        jmsMessagingTemplate.convertAndSend(topic, name);
        //方法二：这种方式不需要手动创建topic,系统会自行创建名为test的队列
        //jmsMessagingTemplate.convertAndSend("test", name);
        return "topic 发送成功";
    }
}
