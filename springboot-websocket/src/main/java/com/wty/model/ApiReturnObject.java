package com.wty.model;

import lombok.Data;

/**
 * @author wty
 * @date 2020/8/24 23:09
 */
@Data
public class ApiReturnObject {
    private int code;
    private Object data;
    private String msg;
}
