package com.wty.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author wty
 * @Date 2019/12/24 12:00
 */
@Data
@Document(indexName = "test_user", type = "doc")
public class User implements Serializable {

    private static final long serialVersionUID = -3801087608776267142L;

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
}
