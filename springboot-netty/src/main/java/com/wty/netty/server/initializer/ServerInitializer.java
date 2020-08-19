package com.wty.netty.server.initializer;

import com.wty.netty.server.handler.CustomHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 初始化器：当channel注册后,会执行里面的响应的初始化方法
 * @author WTY
 * @Date 2020/7/27 16:17
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 通过SocketChannel去获得对应的管道
        ChannelPipeline pipeline = socketChannel.pipeline();
        // 通过管道，添加handler
        // HttpServerCodec是由netty自己提供的助手类,可以理解为拦截器
        // 当请求到服务端,我们需要做编解码,响应到客户端做编码
        pipeline.addLast("HttpServerCodec",new HttpServerCodec());

        // 添加自定义的助手类,返回“hello netty~”
        pipeline.addLast("customHandler",new CustomHandler());
    }
}
