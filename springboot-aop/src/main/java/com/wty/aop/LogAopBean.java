package com.wty.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 根据匹配bean名实现aop
 *
 * @author wty
 * @date 2021/1/2 22:54
 */
@Aspect
@Slf4j
@Component
public class LogAopBean {

    @Pointcut("bean(logController)")
    public void BeanService(){
    }
    @AfterReturning("BeanService()")
    public void printAfter(){
        log.info("bean-------------------前置通知");
    }
}
