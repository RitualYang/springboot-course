package com.wty.model;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * @author wty
 * @date 2019/12/24 18:49
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -9207626360510555637L;

    @Field("id")
    private Long id;
    @Field
    private String username;
    @Field
    private String password;
    @Field
    private Long age;
    @Field
    private String mobile;
    @Field
    private String email;
}
