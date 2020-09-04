package com.wty.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * 用户实体
 * @author ADMIN
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    private String id;
    private String userName;
    private String password;
    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;
}