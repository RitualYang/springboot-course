package com.wty.model;

import lombok.Data;
import lombok.ToString;
import sun.rmi.runtime.Log;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wty
 * @Date 2020/01/04 23:13
 */
@Data
@ToString
@Table(name = "userinfo")
public class UserInfo implements Serializable {
    @Id
    private Long id;
    private Long uid;
    private String mobile;
    private String info;
    private String mail;
    private User user;
}
