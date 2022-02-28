package com.wty.rabbit.mq;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
 * TODO: 包装一下,只做业务代码处理, 所有的确认重试机制通过代理模式增强实现
 */
@Component
public class ConsumerHandler {

    @RabbitListener(queues = {RabbitmqConfig.FIRST_QUEUE})
    public void firstProcess(String msg, Message message, Channel channel) throws IOException {
        try {
            System.out.println("First Queue received msg : " + msg);
            System.out.println("First Queue received message:" + objectToJson(message));
            System.out.println("First Queue received channel:" + objectToJson(channel));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (Exception e) {
            // requeue：为false时,查看是否配置了死信队列 存在丢入死信队列,否则丢弃消息
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
        }

    }

    @RabbitListener(queues = {RabbitmqConfig.SECOND_QUEUE})
    public void secondProcess(String msg, Message message, Channel channel) throws IOException {
        System.out.println("First Queue received msg : " + message);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }

    @RabbitListener(queues = {RabbitmqConfig.FOURTH_QUEUE})
    public void fourthProcess(String msg, Message message, Channel channel) throws IOException {
        System.out.println("First Queue received msg : " + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);

    }

    @RabbitListener(queues = {RabbitmqConfig.THIRD_QUEUE})
    public void thirdProcess(String msg, Message message, Channel channel) throws IOException {
        System.out.println("First Queue received msg : " + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }

    public String objectToJson(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
