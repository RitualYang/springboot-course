package com.wty.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * @author wty
 * @create 2019-11-01 17:07
 */
@Data
@ToString
@Table(name = "user")
public class User implements Serializable {
    private Long uid;
    @Column(name = "username")
    private String userName;
    private String password;
    private Long age;

    private List<UserInfo> userInfos;

}
