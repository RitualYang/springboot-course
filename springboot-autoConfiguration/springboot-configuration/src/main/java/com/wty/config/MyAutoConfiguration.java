package com.wty.config;

import com.wty.service.AutoConfigurationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author wty
 * @Date 2020/8/31 17:07
 */
@Configuration
public class MyAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AutoConfigurationService autoConfigurationService(){
        return new AutoConfigurationService();
    }
}
