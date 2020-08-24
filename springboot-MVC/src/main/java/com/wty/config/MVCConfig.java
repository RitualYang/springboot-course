package com.wty.config;

import com.wty.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wty
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
        // 添加拦截器
        registry.addInterceptor(new TestInterceptor())
                // 拦截对应路径下的请求
                .addPathPatterns("/**");
    }
}
