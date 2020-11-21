package com.wty.rabbit.mq;

import com.rabbitmq.client.Channel;
import com.wty.rabbit.config.RabbitmqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author wty
 * @date 2020/10/24 14:26
 */
@Component
public class ConsumerHandler {

    @RabbitListener(queues = {RabbitmqConfig.FIRST_QUEUE})
    public void firstProcess(String msg, Message message, Channel channel) {
        System.out.println("First Queue received msg : " + msg);
    }

    @RabbitListener(queues = {RabbitmqConfig.SECOND_QUEUE})
    public void secondProcess(String msg, Message message, Channel channel) {
        System.out.println("First Queue received msg : " + message);
    }

    @RabbitListener(queues = {RabbitmqConfig.FOURTH_QUEUE})
    public void fourthProcess(HashMap map, Message message, Channel channel) {
        System.out.println("First Queue received msg : " + map);
    }

    @RabbitListener(queues = {RabbitmqConfig.THIRD_QUEUE})
    public void thirdProcess(HashMap map, Channel channel) {
        System.out.println("First Queue received msg : " + map);
    }
}
