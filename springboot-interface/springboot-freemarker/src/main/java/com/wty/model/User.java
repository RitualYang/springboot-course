package com.wty.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author wty
 * @date 2020/9/4 10:59
 */
@Data
@ToString
public class User {
    private Long id;
    private String username;
    private String address;
}
