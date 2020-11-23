package com.wty.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * TODO
 *
 * @author wty
 * @date 2020/11/23 15:35
 */
@Data
public class ExcelUser implements Serializable {
    @Excel(name = "用户名",orderNum = "1")
    private String userName;
    @Excel(name = "登录密码",orderNum = "2")
    private String password;
    @Excel(name = "年龄",orderNum = "3")
    private String age;

}
