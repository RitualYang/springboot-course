package com.wty.rabbit;

import com.wty.rabbit.mq.ProducerMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * @author wty
 * @date 2020/10/24 14:07
 */
@SpringBootTest
public class RabbitMqProducerTest {

    @Autowired
    private ProducerMessage producerMessage;

    @Test
    public void sendFanoutMessage() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("message", "我是好人");
        stringStringHashMap.put("code", "ok");
        producerMessage.sendFanoutMessage(stringStringHashMap);
    }

    @Test
    public void sendDirectMessage() {
        producerMessage.sendDirectMessage("spring.boot.amqp", "direct send message");
    }

    @Test
    public void sendTopicMessage() {
        producerMessage.sendTopicMessage("kk.boot.hao", "我是测试");
    }
}
