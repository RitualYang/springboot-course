package com.wty;

import com.wty.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * redis测试
 *
 * @author wty
 * @date 2021/1/13 23:44
 */
@SpringBootTest(classes = {RedisApplication.class})
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void loading(){
        try {
            redisTemplate.opsForValue().set("123","3456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        System.out.println(stringRedisTemplate.opsForValue().increment("test"));
        System.out.println(stringRedisTemplate.opsForValue().increment("test"));
        System.out.println(stringRedisTemplate.opsForValue().increment("test"));
        System.out.println(stringRedisTemplate.opsForValue().increment("test"));
        System.out.println(stringRedisTemplate.opsForValue().increment("test1", 30L));
        System.out.println(stringRedisTemplate.opsForValue().increment("test1",30L));
        System.out.println(stringRedisTemplate.opsForValue().increment("test", 100L));
    }
}
