package com.wty;


import com.wty.kafka.KafkaProducerApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * kafka发送者测试
 *
 * @author wty
 * @date 2020/11/21 15:26
 */
@Slf4j
@SpringBootTest(classes = {KafkaProducerApplication.class})
class KafkaProviderTest {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Test
    void contextLoad() {
        log.info("kafkaTemplate: {}" ,kafkaTemplate);
    }

    @Test
    void sendTopic() {
        String message = "KAFKA_LISTENERSKAFKA_LISTENERSKAFKA_LISTENERSKAFKA_LISTENERS";
        kafkaTemplate.send("testTopic", message);
    }

    @Test
    void sendAckTopic() {
        String message = "123";
        kafkaTemplate.send("testTopicByAck", message);
    }
}
