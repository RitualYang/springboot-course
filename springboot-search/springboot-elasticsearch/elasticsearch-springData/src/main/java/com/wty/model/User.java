package com.wty.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author wty
 * @Document
 * @Id : es索引字段
 * @Field
 * @JsonProperty
 * @date 2019/12/24 12:00
 */
@Data
@Document(indexName = "test_user", shards = 1, replicas = 0)
public class User implements Serializable {

    private static final long serialVersionUID = 9108709748606360501L;
    @Id
    @JsonProperty
    private Long id;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private Long age;
    @JsonProperty
    private String mobile;
    @JsonProperty
    private String email;
    @JsonProperty
    @Field(analyzer = "ik_smart",searchAnalyzer = "ik_max_word",type = FieldType.Text)
    private String title;
    @JsonProperty
    @Field(analyzer = "ik_smart",searchAnalyzer = "ik_max_word",type = FieldType.Text)
    private String content;
}
