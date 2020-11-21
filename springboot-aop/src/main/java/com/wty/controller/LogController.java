package com.wty.controller;

import com.wty.annotion.LoginLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wty
 * @date 2020/02/13 19:40
 */
@RestController
@RequestMapping(value = "/aop")
public class LogController {

    @LoginLog(value = "登录")
    @RequestMapping(value = "/login")
    public String login() {
        return "登录";
    }

    @LoginLog(value = "登出")
    @RequestMapping(value = "/logout")
    public String logout() {
        return "登出";
    }
}
