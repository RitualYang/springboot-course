package com.wty.rabbit.mq;

import com.wty.rabbit.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * TODO
 *
 * @author wty
 * @date 2020/10/24 14:26
 */
@Component
public class ConsumerHandler {

    @RabbitListener(queues = {RabbitmqConfig.FIRST_QUEUE})
    public void firstProcess(String message){
        System.out.println("First Queue received msg : " + message);
    }
    @RabbitListener(queues = {RabbitmqConfig.SECOND_QUEUE})
    public void secondProcess(String message){
        System.out.println("First Queue received msg : " + message);
    }
    @RabbitListener(queues = {RabbitmqConfig.FOURTH_QUEUE})
    public void fourthProcess(HashMap message){
        System.out.println("First Queue received msg : " + message);
    }
    @RabbitListener(queues = {RabbitmqConfig.THIRD_QUEUE})
    public void thirdProcess(HashMap message){
        System.out.println("First Queue received msg : " + message);
    }
}
