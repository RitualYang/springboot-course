package com.wty.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * es连接配置
 *
 * @author wty
 * @date 2020/8/25 21:53
 */
@Configuration
public class ElasticsearchConfig {

    @Value("${es.config.request.connectTimeOut:5}")
    private int connectTimeOut;
    @Value("${es.config.request.socketTimeOut:5}")
    private int socketTimeOut;
    @Value("${es.config.request.connectionRequestTimeOut:5}")
    private int connectionRequestTimeOut;

    @Bean
    public RestHighLevelClient client() {
        RestClientBuilder builder = RestClient.builder(
                        new HttpHost("xxx.xxx.xxx.xxx", 9200, "http")
                        //, new HttpHost("127.0.0.1", 9200, "http")
                )
                .setRequestConfigCallback(requestConfigBuilder -> {
                    requestConfigBuilder.setConnectTimeout(connectTimeOut);
                    requestConfigBuilder.setSocketTimeout(socketTimeOut);
                    requestConfigBuilder.setConnectionRequestTimeout(connectionRequestTimeOut);
                    return requestConfigBuilder;
                });
        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }
}
