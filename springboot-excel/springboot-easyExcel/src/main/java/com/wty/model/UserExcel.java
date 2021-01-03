package com.wty.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * excel测试实体
 * @author wty
 * @date 2020/8/24 10:38
 */
@Data
@AllArgsConstructor
public class UserExcel implements Serializable {
    private static final long serialVersionUID = -4787504584468394160L;
    @ExcelIgnore
    private Integer userId;
    @ExcelProperty(value = "用户名", order = 0)
    private String userName;
    @ExcelProperty(value = "年龄", order = 1)
    private Integer age;
    @ExcelProperty(value = "手机号", order = 2)
    private String mobile;
    @ExcelProperty(value = "邮箱", order = 3)
    private String email;
    @ExcelProperty(value = "地址", order = 4)
    private String address;
}
