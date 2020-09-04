package com.wty.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Set;

/**
 * 角色
 * @author ADMIN
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Role {

    private String id;
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private Set<Permissions> permissions;
}