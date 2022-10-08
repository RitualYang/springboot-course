package com.wty.aop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author wty
 * @date 2022/9/5 11:55
 */
@Aspect
@Component
@Slf4j
public class ControllerAspect {

    @Pointcut("execution(public * com.wty..*.web..*Controller.*(..))")
    public void controllerPointcut() {}

    @Around("controllerPointcut()")
    public Object doBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        final TestApi classTestApi = proceedingJoinPoint.getTarget().getClass().getAnnotation(TestApi.class);
        TestApi testApi = method.getAnnotation(TestApi.class);
        if (Objects.isNull(testApi) && Objects.isNull(classTestApi) && Objects.nonNull(attributes)) {
            HttpServletResponse response = attributes.getResponse();
            if (Objects.nonNull(response)) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return null;
            }
        }
        return proceedingJoinPoint.proceed();
    }
}
