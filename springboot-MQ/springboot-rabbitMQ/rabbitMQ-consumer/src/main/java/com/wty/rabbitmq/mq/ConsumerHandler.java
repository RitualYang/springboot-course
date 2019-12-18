package com.wty.rabbitmq.mq;

import com.rabbitmq.client.Channel;
import com.wty.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerHandler {

    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public void send_email(String msg,Message message,Channel channel){
        System.out.println("receive message is:"+msg);
    }

}
