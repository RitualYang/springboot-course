package com.wty.kafka.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author wty
 * @date 2019/12/11 22:12
 */
@Component
@Slf4j
public class ConsumerHandler {

    @KafkaListener(topics = "testTopic")
    public void onMessage(String message) {
        log.info(message);
    }

    //TODO 手工签收
}
