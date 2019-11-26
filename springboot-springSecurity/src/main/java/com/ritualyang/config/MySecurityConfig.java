package com.ritualyang.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()// 授权配置
                // 所有用户均可访问的资源 只支持GET请求,其它请求需做处理
                .antMatchers("/static/**")
                // 任何尚未匹配的URL只需要验证用户即可访问
                .permitAll()
                .anyRequest()// 所有请求
                // 都需要认证
                .authenticated();
        //登录
        http.formLogin().loginPage("templates/login.html")
                .successForwardUrl("templates/index.html");
        //权限拒绝的页面
        http.exceptionHandling().accessDeniedPage("/error.html");
        //登出跳转界面
        http.logout().logoutSuccessUrl("templates/login.html");
    }


}