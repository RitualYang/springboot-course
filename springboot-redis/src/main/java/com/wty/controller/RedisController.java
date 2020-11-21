package com.wty.controller;

import com.wty.utils.JedisUtil;
import com.wty.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wty
 * @date 2019/11/01 21:08
 */
@RestController
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private JedisUtil jedisUtil;

    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public String setValue() {
        return redisUtil.set("msg", "123456");
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getValue() {
        return redisUtil.get("msg");
    }

    @RequestMapping(value = "/setJedis", method = RequestMethod.GET)
    public String setJedisValue() {
        return jedisUtil.set("msg", "123456", 1);
    }

    @RequestMapping(value = "/getJedis", method = RequestMethod.GET)
    public String getJedisValue() {
        return jedisUtil.get("msg", 1);
    }

}