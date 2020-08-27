package com.wty.model;

import lombok.Data;
/**
 * @author wty
 * @Date 2020/8/24 23:09
 * @Description: TODO
 */
@Data
public class ApiReturnObject {
    private int code;
    private Object data;
    private String msg;
}
