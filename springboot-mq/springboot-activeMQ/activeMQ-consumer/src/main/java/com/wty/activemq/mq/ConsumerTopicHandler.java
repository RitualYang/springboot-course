package com.wty.activemq.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author wty
 * @date 2019/12/10 23:04
 */
@Component
public class ConsumerTopicHandler {

    @JmsListener(destination = "springboot-topic", containerFactory = "jmsListenerContainerTopic")
    public void receive(String text) {
        System.out.println("ConsumerTopicHandler:  收到一条信息: " + text);
    }
}
