package com.wty.annotion;

import java.lang.annotation.*;

/**
 *
 * @Retention
 * 注解保持的生命周期。
 * 按生命周期来划分可分为3类：
 * 1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
 * 2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
 * 3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
 * @Target
 * 作用：用于描述注解的使用范围
 * @author wty
 * @create 2020-02-13 19:41
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface LoginLog {

    /**
     * 具体业务具体编辑
     */
    String value() default "";
}
