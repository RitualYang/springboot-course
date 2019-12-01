package com.wty.model;

import lombok.Data;

@Data
public class ApiReturnObject {
    private int code;
    private Object data;
    private String msg;
}
