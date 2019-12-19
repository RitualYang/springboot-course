package com.wty;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RocketMqTest {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void test(){
        // 如下两种方式等价
        rocketMQTemplate.convertAndSend("test-topic-1", "Hello, World!");
        //rocketMQTemplate.send("test-topic-1", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
        log.info("send finished!");
    }



}
