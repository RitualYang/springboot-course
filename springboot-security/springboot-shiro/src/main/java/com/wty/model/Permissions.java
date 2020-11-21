package com.wty.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 权限
 *
 * @author ADMIN
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Permissions {
    private String id;
    private String permissionsName;
}