package com.wty.rabbit.mq;

import com.wty.rabbit.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author wty
 * @date 2020/10/24 14:03
 */
@Component
public class ProducerMessage {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendDirectMessage(String routingKey, String message) {
        rabbitTemplate.convertAndSend(RabbitmqConfig.DIRECT_EXCHANGE, routingKey, message);
    }

    public void sendTopicMessage(String routingKey, String message) {
        rabbitTemplate.convertAndSend(RabbitmqConfig.DIRECT_EXCHANGE, routingKey, message);
    }

    public void sendFanoutMessage(HashMap hashMap) {
        rabbitTemplate.convertAndSend(RabbitmqConfig.FANOUT_EXCHANGE, null, hashMap);
    }
}
