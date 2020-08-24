package com.wty.aop;

import com.wty.annotion.LoginLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author wty
 * @Date 2020/02/13 19:40
 */
@Component
@Aspect
@Slf4j
public class LogAopAnnotation {
    /**
     * 定义切入点,所以带有注解LoginLog的方法
     */
    @Pointcut(value = "@annotation(com.wty.annotion.LoginLog)")
    public void annotationService() {
    }

    /**
     * 环绕通知,已proceed（）方法区分前置环绕、后置环绕
     * 只有环绕通知可以使用 ProceedingJoinPoint
     * @param point
     * @throws Throwable
     */
    @Around("annotationService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {
        log.info("环绕前置通知");
        //先执行业务方法
        Object proceed = point.proceed();
        log.info("环绕后置通知");
        try {
            //获取拦截的方法名
            Signature signature = point.getSignature();
            MethodSignature msig = null;
            if (!(signature instanceof MethodSignature)) {
                //与注解标签Target匹配
                throw new IllegalArgumentException("该注解只能用于方法");
            }
            msig = (MethodSignature) signature;
            log.info("被拦截方法 = " + signature);
            Object target = point.getTarget();
            Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
            String methodName = currentMethod.getName();
            //获取拦截方法的参数
            String className = point.getTarget().getClass().getName();
            Object[] params = point.getArgs();
            log.info("方法名 = " + className + "; 参数 = " + params);
            //获取操作名称
            LoginLog annotation = currentMethod.getAnnotation(LoginLog.class);
            String loginLogName = annotation.value();
            log.info("value = " + loginLogName);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return proceed;
    }
}
