package com.wty.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.wty.interceptor.TestInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 替换序列化方式二种选用一次即可生效
 * 日期格式化输出设置.实体的属性上添加注解
 *
 * @author wty
 * @JSONField(format = "yyyy-MM-dd")
 * 控制字段是否输出,添加注解
 * @JSONField(serialize = true)
 * @date 2020/6/23 22:50
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

    /**
     * 自定义过滤器添加
     * 如果过滤器没有使用@Component注册到容器需要手动注册到过滤器容器中
     * 优点：可以自由配置拦截的URL
     * @return
     */
    /*@Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TimeFilter());
        // 匹配请求路径
        registration.addUrlPatterns("/*");
        registration.setName("TimeFilter");
        registration.setOrder(1);
        return registration;
    }*/

    /**
     * 全局跨域解决方案
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

    /**
     * 替换序列化方式-1-
     * 使用 fastjson 代替 jackson
     * 先把JackSon的消息转换器删除.
     * (1)源码分析可知,返回json的过程为:
     * Controller调用结束后返回一个数据对象,for循环遍历conventers,找到支持application/json的HttpMessageConverter,然后将返回的数据序列化成json。
     * 具体参考org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor的writeWithMessageConverters方法
     * (2)由于是list结构,我们添加的fastjson在最后。因此必须要将jackson的转换器删除,不然会先匹配上jackson,导致没使用 fastjson
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (int i = converters.size() - 1; i >= 0; i--) {
            if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
                converters.remove(i);
            }
        }
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //自定义fastjson配置
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                // 是否输出值为null的字段,默认为false,我们将它打开
                SerializerFeature.WriteMapNullValue,
                // 将Collection类型字段的字段空值输出为[]
                SerializerFeature.WriteNullListAsEmpty,
                // 将字符串类型字段的空值输出为空字符串
                SerializerFeature.WriteNullStringAsEmpty,
                // 将数值类型字段的空值输出为0
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteDateUseDateFormat,
                // 禁用循环引用
                SerializerFeature.DisableCircularReferenceDetect
        );
        fastJsonHttpMessageConverter.setFastJsonConfig(config);
        // 添加支持的MediaTypes;不添加时默认为*/*,也就是默认支持全部
        // 但是MappingJackson2HttpMessageConverter里面支持的MediaTypes为application/json
        // 参考它的做法, fastjson也只添加application/json的MediaType
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        converters.add(fastJsonHttpMessageConverter);
    }

    /**
     * 替换序列化方式-2-
     * +支持fastjson的HttpMessageConverter
     * @return HttpMessageConverters
     */
    /*@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        //1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2:添加fastJson的配置信息;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.DisableCircularReferenceDetect);
        fastJsonConfig.setCharset(Charset.forName("utf-8"));
        //3.处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON);
        //4.在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        return new HttpMessageConverters(converter);
    }*/
}
