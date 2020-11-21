package com.wty.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 *
 * @author wty
 * @date 2020/6/23 22:52
 */
@Slf4j
public class TestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("在请求处理之前进⾏调⽤(Controller⽅法调⽤之前)");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("请求处理之后进⾏调⽤,但是在视图被渲染之前(Controller⽅法调⽤之后),如果异常发⽣,则该⽅法不会被调⽤");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("该⽅法将在整个请求结束之后被调用,也就是在DispatcherServlet渲染了对应的视图之后执⾏(主要用于进行资源清理工作,基本可以不重写)");
    }
}
