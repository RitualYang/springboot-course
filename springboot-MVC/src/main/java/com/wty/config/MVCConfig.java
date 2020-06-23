package com.wty.config;

import com.wty.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author WTY
 * @Date 2020/6/23 22:50
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {
    /**
     * 添加拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor())// 添加拦截器
                .addPathPatterns("/**");// 拦截对应路径下的请求
    }
}
