package com.wty;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author wty
 * @date 2021/12/21 15:03
 * 描述:
 */
@SpringBootTest(classes = RedisApplication.class)
public class RedissonTest {


    @Resource
    private RedissonClient redissonClient;

    @Resource
    private Redisson redisson;

    @Test
    public void Loading() {
    }
}
