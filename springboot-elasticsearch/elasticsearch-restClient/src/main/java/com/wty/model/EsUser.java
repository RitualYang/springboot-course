package com.wty.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * es测试用户实体
 *
 * @author wty
 * @date 2020/8/25 22:50
 */
@Data
@AllArgsConstructor
public class EsUser {
    private String userName;
    private Integer age;
    private String gander;
}
