package com.wty.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Order(2): 改变启动优先级
 * 项目启动运行调用
 * @author wty
 * @Date 2020/5/4 17:28
 */
@Order(2)
@Slf4j
@Component
public class BootApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("This is BootApplicationRunner...");
    }
}
