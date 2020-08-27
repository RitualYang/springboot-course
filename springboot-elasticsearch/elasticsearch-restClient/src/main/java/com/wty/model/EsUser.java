package com.wty.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * TODO:xxx
 *
 * @author wty
 * @Date 2020/8/25 22:50
 */
@Data
@AllArgsConstructor
public class EsUser {
    private String userName;
    private Integer age;
    private String gander;
}
