package com.wty.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wty
 * @Date 2019/10/26 21:01
 */
@Configuration
public class RabbitmqConfig {

    /**
     * 声明队列
     */
    public final static String FIRST_QUEUE = "firstQueue";
    public final static String SECOND_QUEUE = "secondQueue";
    public final static String THIRD_QUEUE = "thirdQueue";
    public final static String FOURTH_QUEUE = "fourthQueue";

    @Bean("firstQueue")
    public Queue getFirstQueue(){
        return new Queue(FIRST_QUEUE,true);
    }
    @Bean("secondQueue")
    public Queue getSecondQueue(){
        return new Queue(SECOND_QUEUE,true);
    }
    @Bean("thirdQueue")
    public Queue getThirdQueue(){
        return new Queue(THIRD_QUEUE,true);
    }
    @Bean("fourthQueue")
    public Queue getFourthQueue(){
        return new Queue(FOURTH_QUEUE,true);
    }
    /**
     * 在消费端转换JSON消息
     * 监听类都要加上containerFactory属性
     * @param connectionFactory
     * @return
     */
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        factory.setAutoStartup(true);
        return factory;
    }
}
