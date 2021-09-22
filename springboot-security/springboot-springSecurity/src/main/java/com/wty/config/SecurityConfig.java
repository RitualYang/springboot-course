package com.wty.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wty.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * security配置
 *
 * @author wty
 * @date 2020/9/4 16:00
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserService userService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //.loginPage("/login.html")//登录页面
                //.loginProcessingUrl("/toLogin")// 处理登录post
                // 成功返回
                .successHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter pw = response.getWriter();
                    Map<String, Object> map = new HashMap<>();
                    map.put("status", 200);
                    map.put("msg", authentication.getPrincipal());
                    pw.write(new ObjectMapper().writeValueAsString(map));
                    pw.flush();
                    pw.close();
                })
                // 失败返回
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter pw = response.getWriter();
                    Map<String, Object> map = new HashMap<>();
                    map.put("status", 401);
                    if (exception instanceof LockedException) {
                        map.put("msg", "账户被锁定，登陆失败！");
                    } else if (exception instanceof BadCredentialsException) {
                        map.put("msg", "账户或者密码错误，登陆失败！");
                    } else if (exception instanceof DisabledException) {
                        map.put("msg", "账户被禁用，登陆失败！");
                    } else if (exception instanceof AccountExpiredException) {
                        map.put("msg", "账户已过期，登陆失败！");
                    } else if (exception instanceof CredentialsExpiredException) {
                        map.put("msg", "密码已过期，登陆失败！");
                    } else {
                        map.put("msg", "登陆失败！");
                    }
                    pw.write(new ObjectMapper().writeValueAsString(map));
                    pw.flush();
                    pw.close();
                })
                //.successForwardUrl("/hello") // 登录后跳转页面
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    /**
     * 密码加密方式
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        DelegatingPasswordEncoder delegatingPasswordEncoder = (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
        delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(new SCryptPasswordEncoder());
        return delegatingPasswordEncoder;
    }
}
