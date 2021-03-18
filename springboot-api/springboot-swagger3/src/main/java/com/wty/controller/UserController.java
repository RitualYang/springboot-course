package com.wty.controller;

import com.wty.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author wty
 * @date 2019/10/13 00:28
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping("/getUser")
    @ApiOperation(value = "获取用户", notes = "")
    @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String")
    public User getUser(String name) {
        User user = new User();
        user.setDate(new Date());
        user.setName("wty");
        user.setPassword("123456");
        return user;
    }
}
