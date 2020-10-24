package com.wty.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wty
 * @Date 2019/10/26 21:01
 */
@Configuration
public class RabbitmqConfig {
    /**
     * 声明交换机
     * direct：
     * topic：
     * fanout： 广播交换机
     */
    public final static String DIRECT_EXCHANGE = "directExchange";
    public final static String TOPIC_EXCHANGE = "topicExchange";
    public final static String FANOUT_EXCHANGE = "fanoutExchange";

    /**
     * 声明队列
     */
    public final static String FIRST_QUEUE = "firstQueue";
    public final static String SECOND_QUEUE = "secondQueue";
    public final static String THIRD_QUEUE = "thirdQueue";
    public final static String FOURTH_QUEUE = "fourthQueue";

    /**
     * 声明routingKey
     */
    private final static String DIRECT_ROUTING_KEY = "spring.boot.amqp";
    private final static String TOPIC_ROUTING_KEY = "*.boot.*";

    @Bean("directExchange")
    public DirectExchange getDirectExchange(){

        return new DirectExchange(DIRECT_EXCHANGE,true,false);
    }
    @Bean("topicExchange")
    public TopicExchange getTopicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE,true,false);
    }
    @Bean("fanoutExchange")
    public FanoutExchange getFanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE,true,false);
    }

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

    @Bean
    public Binding bindFirst(@Qualifier("firstQueue") Queue queue, @Qualifier("directExchange")
            DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(DIRECT_ROUTING_KEY);
    }
    @Bean
    public Binding bindSecond(@Qualifier("secondQueue") Queue queue, @Qualifier("topicExchange")
            TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(TOPIC_ROUTING_KEY);
    }
    @Bean
    public Binding bindThird(@Qualifier("thirdQueue") Queue queue, @Qualifier("fanoutExchange")
            FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }
    @Bean
    public Binding bindFourth(@Qualifier("fourthQueue") Queue queue, @Qualifier("fanoutExchange")
            FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

    /**
     * 所有的消息发送都会转换成JSON格式发到交换机
     * @param connectionFactory
     * @return
     */
    @Bean("rabbitTemplate")
    public RabbitTemplate getRabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

}
