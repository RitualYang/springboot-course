package com.wty.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * TODO
 *
 * @author wty
 * @Date 2020/8/30 21:53
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class Knife4jConfiguration {
}
