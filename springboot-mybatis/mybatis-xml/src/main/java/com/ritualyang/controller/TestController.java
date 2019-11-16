package com.ritualyang.controller;

import com.ritualyang.mapper.UserMapper;
import com.ritualyang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RitualYang
 * @create 2019-11-01 18:00
 */
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping(value = "/selectOne",method = RequestMethod.GET)
    public String selectOne(){
        User user = userMapper.selectOneUser("123456");
        return user.toString();
    }
}
