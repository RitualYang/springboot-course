package com.wty.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wty
 * @date 2019/10/26 21:01
 */
@Configuration
public class RabbitmqConfig {

    @Autowired
    private Environment environment;
    /**
     * 声明交换机
     * direct：直连交换机
     * topic： 匹配交换机
     * fanout： 广播交换机
     */
    public final static String DIRECT_EXCHANGE = "directExchange";
    public final static String TOPIC_EXCHANGE = "topicExchange";
    public final static String FANOUT_EXCHANGE = "fanoutExchange";
    public final static String COMMON_EXCHANGE = "commonExchange";
    public final static String DEED_EXCHANGE = "deedExchange"; // 死信交换机

    /**
     * 声明队列
     */
    public final static String FIRST_QUEUE = "firstQueue";
    public final static String SECOND_QUEUE = "secondQueue";
    public final static String THIRD_QUEUE = "thirdQueue";
    public final static String FOURTH_QUEUE = "fourthQueue";
    public final static String COMMON_QUEUE = "commonQueue";
    public final static String DEED_QUEUE = "deedQueue"; // 死信队列

    /**
     * 声明routingKey
     */
    private final static String DIRECT_ROUTING_KEY = "spring.boot.amqp";
    private final static String TOPIC_ROUTING_KEY = "*.boot.*";

    @Bean(DIRECT_EXCHANGE)
    public DirectExchange getDirectExchange() {
        return new DirectExchange(DIRECT_EXCHANGE, true, false);
    }

    @Bean(TOPIC_EXCHANGE)
    public TopicExchange getTopicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE, true, false);
    }

    @Bean(FANOUT_EXCHANGE)
    public FanoutExchange getFanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE, true, false);
    }

    @Bean(COMMON_EXCHANGE)
    public DirectExchange getCommonExchange() {
        return new DirectExchange(COMMON_EXCHANGE, true, false);
    }

    @Bean(DEED_EXCHANGE)
    public DirectExchange getDeedExchange() {
        return new DirectExchange(DEED_EXCHANGE, true, false);
    }

    @Bean(FIRST_QUEUE)
    public Queue getFirstQueue() {
        return new Queue(FIRST_QUEUE, true);
    }

    @Bean(SECOND_QUEUE)
    public Queue getSecondQueue() {
        return new Queue(SECOND_QUEUE, true);
    }

    @Bean(THIRD_QUEUE)
    public Queue getThirdQueue() {
        return new Queue(THIRD_QUEUE, true);
    }

    @Bean(FOURTH_QUEUE)
    public Queue getFourthQueue() {
        return new Queue(FOURTH_QUEUE, true);
    }

    @Bean(COMMON_QUEUE)
    public Queue getCommonQueue() {
        Map<String,Object> deadParamsMap = new HashMap<String, Object>();
        // 设置死信队列的Exchange
        deadParamsMap.put("x-dead-letter-exchange", DEED_EXCHANGE);
        //设置死信队列的RouteKey
        deadParamsMap.put("x-dead-letter-routing-key",DEED_QUEUE);
        return new Queue(COMMON_QUEUE,true,false,false,deadParamsMap);
    }

    @Bean(DEED_QUEUE)
    public Queue getDeedQueue() {
        return new Queue(DEED_QUEUE, true);
    }

    @Bean
    public Binding bindFirst(@Qualifier("firstQueue") Queue queue, @Qualifier("directExchange")
            DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DIRECT_ROUTING_KEY);
    }

    @Bean
    public Binding bindSecond(@Qualifier("secondQueue") Queue queue, @Qualifier("topicExchange")
            TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(TOPIC_ROUTING_KEY);
    }

    @Bean
    public Binding bindThird(@Qualifier("thirdQueue") Queue queue, @Qualifier("fanoutExchange")
            FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding bindFourth(@Qualifier("fourthQueue") Queue queue, @Qualifier("fanoutExchange")
            FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding bindCommon(@Qualifier(COMMON_QUEUE) Queue queue, @Qualifier(COMMON_EXCHANGE) DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(COMMON_QUEUE);
    }

    @Bean
    public Binding bindDeed(@Qualifier(DEED_QUEUE) Queue queue, @Qualifier(DEED_EXCHANGE) DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEED_QUEUE);
    }

    /**
     * 所有的消息发送都会转换成JSON格式发到交换机
     * 确认消息配置, 非十分重要的消息, 不建议采用此配置
     * @param connectionFactory
     * @return
     */
    @Bean("reliableRabbitTemplate")
    public RabbitTemplate getReliableRabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("发送状态：" + (ack ? "成功" : String.format("失败, 原因:%s", cause)));
            }
        });
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             * @param message 返回的消息
             * @param replyCode 回复代码
             * @param replyText 回复文本
             * @param exchange 交换机
             * @param routingKey 路由键
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println(String.format("message:%s,replayCode:%d,replyText:%s,exchange:%s, routingKey,%s",
                        message, replyCode, replyText, exchange, routingKey));
                MessageProperties messageProperties = message.getMessageProperties();
                rabbitTemplate.convertAndSend(exchange,  routingKey, message);
            }
        });
        return rabbitTemplate;
    }

    @Bean("rabbitTemplate")
    public RabbitTemplate getRabbitTemplate() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(environment.getProperty("spring.rabbitMQ.host"));
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.NONE);
        connectionFactory.setPublisherReturns(false);
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

}
