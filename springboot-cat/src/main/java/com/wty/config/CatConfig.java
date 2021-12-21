package com.wty.config;

import com.dianping.cat.Cat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author Created by xiaoxian 2021/01/22.
 * @version v0.1.0
 * @see <font color="#0000FF">house-parent</font>
 */
@Slf4j
@Configuration
public class CatConfig {
    /**
     * 每个项目的domain都是不同的
     * 所以不要从Apollo中读取
     * 建议使用的Apollo的app.id
     */
    @Value("${spring.application.name}")
    private String domain;

    @Value("${app.id:123}")
    private String appId;

    /**
     * CAT服务端的端口，从Apollo中读取
     */
    @Value("${cat.server.port:2280}")
    private int port;

    /**
     * CAT服务端的HTTP端口，从Apollo中读取
     */
    @Value("${cat.server.http.port:8080}")
    private int httpPort;

    /**
     * CAT服务端的IP列表，多个以逗号分隔，从Apollo中读取
     */
    @Value("${cat.server.servers:10.88.99.26,127.0.0.1}")
    private String servers;

    /**
     * 初始化CAT客户端
     */
    @PostConstruct
    public void initCat() {
        try {
            // TODO 此配置需要修改源码 DefaultClientConfigManager.initialize() 方法完成对client.xml配置的加载
            log.info("Initialization of CAT client port:{},httpPort:{},domain:{},appId:{},servers:{}", port, httpPort, domain, appId, servers);
            Cat.initializeByDomain(domain != null && !"unknown".equalsIgnoreCase(domain) ? domain : appId, port, httpPort, servers.split(","));
        } catch (Exception e) {
            log.error("Initialization of CAT client failed", e);
        }
    }
}