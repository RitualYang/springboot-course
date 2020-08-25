package com.test.rabbitMQ;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * rabblitMQ消费者
 * @author wty
 * @Date 2019/10/26 15:44
 */
public class consumer {
    private static final String QUEUE = "helloworld";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);//端口：消费者通信端口
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        //设置虚拟机,一个mq服务可以设置多个虚拟机,每个虚拟机就相当于一个单独的mq
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        //建立新连接
        connection = connectionFactory.newConnection();
        //创建会话通道,生产者和mq服务所有通信在channel通道完成
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE, true, false, false, null);
        //定义消费方法
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            /**
             * 当接收消息后此方法将被调用
             * @param consumerTag 消费者的标签,在channel.basicConsume()去指定
             * @param envelope 消息包的内容(信封),可从中获取消息id,消息routingkey,交换机,消息和重传标志 (收到消息失败后是否需要重新发送)
             * @param properties 消息的属性
             * @param body
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //交换机
                String exchange = envelope.getExchange();
                //消息id,mq在channel中用标识消费的id,可用于确认消息已接收
                long deliveryTag = envelope.getDeliveryTag();
                //消息内容
                String message = new String(body,"utf-8");
                System.out.println("message = " + message);
            }
        };
        channel.basicConsume(QUEUE,true,consumer);
    }
}
