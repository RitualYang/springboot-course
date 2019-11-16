package com.ritualyang.utils;

import com.ritualyang.pojo.ApiReturnObject;

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
