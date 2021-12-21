package com.wty.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wty
 * @date 2021/12/21 14:55
 * 描述:
 */
@Configuration
public class RedissonConfig {


    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;

    /**
     * 创建redissonClient
     * @return
     */
    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(host + ":" + port)
                .setPassword(password);
        return Redisson.create(config);
    }

}
