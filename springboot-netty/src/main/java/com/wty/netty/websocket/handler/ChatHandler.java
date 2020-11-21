package com.wty.netty.websocket.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * 处理消息的handler
 * TextWebSocketFrame: 在netty中,是用于为websocket专门处理文本的对象,frame是消息的载体
 *
 * @author wty
 * @date 2020/8/9 10:21
 */
@Slf4j
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    /**
     * 用于记录和管理所有客户端的channel
     */
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String content = msg.text();
        log.info("接受到的数据: " + content);
        for (Channel client : clients) {
            client.writeAndFlush(
                    new TextWebSocketFrame("[服务器在:]" + LocalDateTime.now() + "接受到消息,消息为:" + content));
        }
        // 下面的方法等同于上方for循环
        clients.writeAndFlush(new TextWebSocketFrame("[服务器在:]" + LocalDateTime.now() + "接受到消息,消息为:" + content));
    }

    /**
     * 当客户端连接服务端之后(打开连接)
     * 获取客户端的channel,并且放到channelGroup中去进行管理
     *
     * @param ctx
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
    }

    /**
     * @param ctx
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 当触发handlerRemoved,ChannelGroup会自动移除客户端的channel
        // clients.remove(ctx.channel());
        log.info(ctx.channel().id() + " 长id:" + ctx.channel().id().asLongText());
        log.info(ctx.channel().id() + " 长id:" + ctx.channel().id().asLongText());
        log.info(ctx.channel().id() + " 短id:" + ctx.channel().id().asShortText());
    }
}
