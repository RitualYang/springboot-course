package com.wty.controller;

import com.alibaba.excel.EasyExcel;
import com.wty.model.UserExcel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * easyExcel测试接口
 *
 * @author wty
 * @date 2020/8/24 10:30
 */
@Controller
@RequestMapping("/easyExcel")
public class EasyExcelController {

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), UserExcel.class).sheet("模板").doWrite(data());
    }

    private List<UserExcel> data() {
        ArrayList<UserExcel> userExcels = new ArrayList<>();
        userExcels.add(new UserExcel(1, "admin", 18, "15555555555", "1@qq.com", "北京"));
        userExcels.add(new UserExcel(2, "admin", 18, "15555555555", "2@qq.com", "上海"));
        userExcels.add(new UserExcel(3, "admin", 18, "15555555555", "3@qq.com", "广州"));
        userExcels.add(new UserExcel(4, "admin", 13, "15555555555", "4@qq.com", "深圳"));
        userExcels.add(new UserExcel(5, "admin", 12, "15555555555", "5@qq.com", "杭州"));
        userExcels.add(new UserExcel(6, "admin", 23, "15555555555", "6@qq.com", "成都"));
        return userExcels;
    }
}
