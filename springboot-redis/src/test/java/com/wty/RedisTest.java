package com.wty;

import com.wty.utils.RedisUtil;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

/**
 * redis测试
 *
 * @author wty
 * @date 2021/1/13 23:44
 */
@SpringBootTest(classes = {RedisApplication.class})
class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    void addItem() {
        String key = "itemKey";
        for (int i = 0;i< 990;i++) {
            stringRedisTemplate.opsForList().rightPush(key, "test1"+ i);
            final long itemSize = stringRedisTemplate.opsForList().size(key);
            if (itemSize > 10) {
                System.out.println(stringRedisTemplate.opsForList().leftPop(key));
            }
        }

    }
    @Test
    void loading(){
        try {
            redisTemplate.opsForValue().set("123","3456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testExp() {
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 15000; i++) {
            System.out.println(incrementExpire("key+" + i, 1000, 3, TimeUnit.HOURS));
        }
        System.out.println((System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    private static final RedisScript<Long> INCR_EXPIRE_SCRIPT = new DefaultRedisScript<>(
            "local i = redis.call('INCRBY', KEYS[1], ARGV[1]) \n"
                    + " redis.call('EXPIRE', KEYS[1], ARGV[2]) \n"
                    + " return i", Long.class);


    public long incrementExpire(String key, long increment, long timeout, TimeUnit unit) {
        Long redisValue = (Long) redisTemplate.execute(INCR_EXPIRE_SCRIPT, Lists.newArrayList(key),
                increment,
                unit.toSeconds(timeout));
        return Objects.isNull(redisValue) ? 0L:redisValue;
    }

    @Test
    void test() {
        System.out.println(stringRedisTemplate.opsForValue().increment("test"));
        System.out.println(stringRedisTemplate.opsForValue().increment("test"));
        System.out.println(stringRedisTemplate.opsForValue().increment("test"));
        System.out.println(stringRedisTemplate.opsForValue().increment("test"));
        System.out.println(stringRedisTemplate.opsForValue().increment("test1", 30L));
        System.out.println(stringRedisTemplate.opsForValue().increment("test1",30L));
        System.out.println(stringRedisTemplate.opsForValue().increment("test", 100L));
    }
}
