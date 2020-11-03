package com.wty.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author wty
 * @Date 2020/02/13 19:58
 */
@Aspect
@Slf4j
@Component
public class LogAopExecution {
    /**
     * controller包下所有方法
     */
    @Pointcut(value = "execution(* com.wty.controller.*.*(..))")
    public void executionService(){
    }

    /**
     * 前置通知
     * @param point
     * @throws Exception
     */
    @Before("executionService()")
    //@Before("execution(* com.wty.com.wty.com.wty.controller.*(..))") 效果同上
    public void before(JoinPoint point){
        log.info("----Bufore前置通知调用----");
    }

    /**
     * 后置通知（出现异常依旧会调用）
     * @param point
     * @throws Exception
     */
    @After("executionService()")
    public void after(JoinPoint point){
        log.info("----After通知调用----");
    }

    /**
     * return返回值前,通知（如果出现异常则不调用）
     * @param point
     * @throws Exception
     */
    @AfterReturning("executionService()")
    public void afterReturning(JoinPoint point){
        log.info("----AfterReturning后置通知调用----");
    }

    /**
     * 异常通知
     * @param point
     * @throws Exception
     */
    @AfterThrowing("executionService()")
    public void afterThrowing(JoinPoint point){
        log.error("----发生异常----" + point.getTarget().getClass().getName());
    }


}
