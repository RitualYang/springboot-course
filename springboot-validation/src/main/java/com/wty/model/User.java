package com.wty.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author WTY
 * @Date 2020/6/23 22:36
 */
@Data
public class User {
    @NotNull(message = "用户信息必须携带用户名")
    private String username;
    private String password;
    private int age;
    private String mobile;
    private String email;
}
