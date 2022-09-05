package com.wty.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author peter
 * @date 2022/9/2 14:58
 */
@Slf4j
@Configuration
public class SpringbootConfig {

    @Bean(value = "test")
    @ConditionalOnProperty(value = "test.open", matchIfMissing = false)
    public Object getObject() {
        log.info("test ConditionalOnProperty");
        return new Object();
    }

}
