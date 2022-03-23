package com.wty;


import com.wty.kafka.KafkaProducerApplication;
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
@SpringBootTest(classes = {KafkaProducerApplication.class})
public class KafkaProviderTest {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Test
    public void contextLoad(){}

    @Test
    public void send() {
        String message = "123";
        kafkaTemplate.send("testTopic", message);
    }
}
