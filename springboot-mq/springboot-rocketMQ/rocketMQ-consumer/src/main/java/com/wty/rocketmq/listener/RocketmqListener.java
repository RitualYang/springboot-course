package com.wty.rocketmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RocketMQMessageListener(topic = "test", consumerGroup = "my-group")
public class RocketmqListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.info("接收消息：  " + message);
    }
}
