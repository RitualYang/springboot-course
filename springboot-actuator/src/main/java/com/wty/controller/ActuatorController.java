package com.wty.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author WTY
 * @Date 2020/8/26 21:17
 */
@RestController
@RequestMapping("/actuator")
public class ActuatorController {

    @Value("${spring.application.name}")
    private String serviceName;
    @Value("${server.port}")
    private String port;

    @GetMapping("/getServiceInfo")
    public String getServiceInfo(){
        return String.format("本服务名：%d,服务端口号为：%d",serviceName,port);
    }
    /**
     * /actuator/beans : 获取本服务的上下文创建的全部bean
     * /actuator/health ：获取本服务的健康状态
     * /actuator/info : 获取本服务指定发布的信息,自动读取配置文件的info信息
     * /actuator/conditions :  提供自动配置报告，记录哪些自动配置通过，哪些没有通过
     * /actuator/configprops :  描述配置属性(包含默认值)如何注入到bean
     * /actuator/env : 获取全部环境配置信息
     * /actuator/loggers : 查看日志配置信息
     * /actuator/heapdump : 查看系统的缓存管理器(可根据缓存管理器名称查询)(DELETE操作可清除缓存)
     * /actuator/threaddump : 获取线程活动的快照
     * /actuator/metrics : 统计程序的各种度量信息，如内存用量和请求数
     * /actuator/scheduledtasks : 查看系统发布的定时任务信息
     * /actuator/mappings : 描述全部的URI路径，及和控制器的映射关系.
     */
}
