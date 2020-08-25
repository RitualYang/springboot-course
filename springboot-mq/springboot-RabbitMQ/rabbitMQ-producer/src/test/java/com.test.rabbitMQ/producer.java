package com.test.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * rabbitMQ提供者
 * @author wty
 * @Date 2019/10/26 15:11
 */
public class producer {

    private static final String QUERUE = "helloworld";
    public static void main(String[] args) throws IOException, TimeoutException {
        String messgae = "hello world springboot-coures";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);//端口：消费者通信端口
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        //设置虚拟机,一个mq服务可以设置多个虚拟机,每个虚拟机就相当于一个单独的mq
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try {
            //建立新链接
            connection = connectionFactory.newConnection();
            //创建会话通道,生产者和mq服务所有通信都在channel通道中完成
            channel = connection.createChannel();
            //声明队列,如果队列在mq中没有则创建
            /**
             * 参数明细
             * 1. 队列名称
             * 2. 是否持久化,如果持久化,mq重启后队列还在
             * 3. 是否独占连接,队列只允许在该连接中访问,如果连接关闭队列会自动删除,如果将此参数设置为true可用于临时队列的创建
             * 4. 自动删除,队列不再使用时是否自动删除此队列,如果将此参数和exclusiver参数设置为true就可以实现临时队列（队列不用了就自动删除）
             * 5. 参数,可以设置为一个队列的扩展参数,比如,可设置存货时间
             */
            channel.queueDeclare(QUERUE,true,false,false,null);
            //发送消息
            /**
             * 参数明细
             * 1. 交换机,如果不指定将使用mq的默认交换机
             * 2. 路由key,是用于Exchange（交换机）将消息转发到指定的消息队列
             * 3. 消息包含的属性
             * 4. 消息内容
             *
             */
            channel.basicPublish("",QUERUE,null,messgae.getBytes());
            System.out.println(" send   to  mq :" + messgae );
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        channel.close();
        connection.close();

        }
    }


}
