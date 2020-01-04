package com.wty.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author RitualYang
 * @create 2019-11-01 17:07
 */
@Data
@ToString
@Table(name = "user")
public class User implements Serializable {
    private Long uid;
    private String username;
    private String password;
    private Long age;

}
