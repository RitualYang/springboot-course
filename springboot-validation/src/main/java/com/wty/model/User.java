package com.wty.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author wty
 * @date 2020/6/23 22:36
 */
@Data
public class User {
    @NotNull(message = "用户信息必须携带用户名")
    private String username;
    @NotNull(message = "密码必须不为空")
    private String password;
    private int age;
    private String mobile;
    private String email;
}
