package com.wty.runner;

import com.wty.netty.websocket.WSServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * @author wty
 * @date 2020/8/26 16:46
 */
@Order(1)
@Slf4j
@Component
public class WSApplicationRunner implements ApplicationRunner {

    @Autowired
    private WSServer wsServer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(wsServer);
        wsServer.start();
    }
}
