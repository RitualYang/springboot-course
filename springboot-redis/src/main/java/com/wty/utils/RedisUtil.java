package com.wty.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author wty
 * @create 2019-12-04 21:34
 */
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    public String set(String key,String msg) {
        redisTemplate.opsForValue().set(key,msg);
        return "success";
    }

    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }
}
