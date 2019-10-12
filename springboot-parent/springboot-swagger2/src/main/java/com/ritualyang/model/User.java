package com.ritualyang.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author RitualYang
 * @create 2019-10-13 00:29
 */
@Data
@ApiModel(value = "用户")
public class User {
    private String name;
    private String password;
    private Date date;
}
