package com.wty.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * es测试用户实体
 *
 * @author wty
 * @date 2020/8/25 22:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EsUser {
    private Long id;
    private String userName;
    private Integer age;
    private boolean gander;
}
