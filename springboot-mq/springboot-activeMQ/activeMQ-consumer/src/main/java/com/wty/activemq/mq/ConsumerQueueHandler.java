package com.wty.activemq.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ConsumerQueueHandler {

    // 使用JmsListener配置消费者监听的队列,其中name是接收到的消息
    @JmsListener(destination = "springboot-queue",containerFactory = "jmsListenerContainerQueue")
    // SendTo 会将此方法返回的数据, 写入到 OutQueue 中去.
    @SendTo("SQueue")
    public String receive(String text) {
        System.out.println("ConsumerQueueHandler : 收到一条消息: " + text);
        return "成功接受 ： " + text;
    }

}
