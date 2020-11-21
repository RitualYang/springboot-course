package com.wty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * esClient启动
 *
 * @author wty
 * @date 2020/8/25 20:10
 */
@SpringBootApplication
public class ElasticsearchClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchClientApplication.class, args);
    }
}
