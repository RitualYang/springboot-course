package com.wty;

import com.wty.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * TODO
 *
 * @author wty
 * @date 2021/1/13 23:44
 */
@SpringBootTest(classes = {RedisApplication.class})
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void loading(){
        try {
            redisTemplate.opsForValue().set("123","3456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
