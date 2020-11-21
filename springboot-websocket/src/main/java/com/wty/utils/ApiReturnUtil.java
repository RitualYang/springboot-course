package com.wty.utils;

import com.wty.model.ApiReturnObject;

/**
 * @author wty
 * @date 2020/8/24 23:09
 */
public class ApiReturnUtil {
    public static ApiReturnObject error(String msg) {
        ApiReturnObject apiReturnObject = new ApiReturnObject();
        apiReturnObject.setMsg(msg);
        return apiReturnObject;
    }

    public static ApiReturnObject success(String msg) {
        ApiReturnObject apiReturnObject = new ApiReturnObject();
        apiReturnObject.setMsg(msg);
        return apiReturnObject;
    }
}
