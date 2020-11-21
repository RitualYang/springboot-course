package com.wty.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wty
 * @date 2020/7/27 10:33
 */
@Data
public class R implements Serializable {

    private Integer code;
    private String message;

    public R(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static R error(int code, String message) {
        return new R(code, message);
    }

    public static R ok(String message) {
        return new R(200, message);
    }
}
