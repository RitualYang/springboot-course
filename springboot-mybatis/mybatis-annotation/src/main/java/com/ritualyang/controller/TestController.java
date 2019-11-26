package com.ritualyang.controller;

import com.ritualyang.mapper.UserMapper;
import com.ritualyang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RitualYang
 * @create 2019-11-01 17:14
 */
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public String testSelect(){
        User user1 = userMapper.selcetOneUser("123456");
        return user1.toString();
    }
}