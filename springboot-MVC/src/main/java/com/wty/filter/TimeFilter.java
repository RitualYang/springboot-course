package com.wty.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * TODO
 *
 * @author wty
 * @Date 2020/9/13 23:31
 */
@Slf4j
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("时间过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("开始执行过滤器");
        Long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        log.info("【过滤器】耗时 " + (System.currentTimeMillis()- start));
        log.info("结束执行过滤器");
    }

    @Override
    public void destroy() {
        log.info("时间过滤器被销毁");
    }
}
