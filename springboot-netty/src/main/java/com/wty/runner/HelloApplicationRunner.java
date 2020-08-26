package com.wty.runner;

import com.wty.netty.server.HelloServer;
import com.wty.netty.websocket.WSServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author WTY
 * @Date 2020/8/26 16:46
 */
@Order(2)
@Slf4j
@Component
public class HelloApplicationRunner implements ApplicationRunner {

    @Autowired
    private HelloServer helloServer;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(helloServer);
        helloServer.start();
    }
}
