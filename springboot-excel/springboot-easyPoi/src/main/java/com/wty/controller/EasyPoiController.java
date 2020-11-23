package com.wty.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.wty.model.ExcelUser;
import com.wty.utils.ExcelUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

/**
 * TODO
 *
 * @author wty
 * @date 2020/11/23 15:38
 */
@RestController
public class EasyPoiController {

    @ResponseBody
    @PostMapping("/import")
    public String importFile(@RequestParam("file") MultipartFile file){
        try {
            List<ExcelUser> users = ExcelUtils.importExcel(file,0,1, ExcelUser.class);
            System.out.println(users);
        } catch (IOException e) {
            e.printStackTrace();
            return "导入失败";
        }
        return "导入成功";
    }
    @GetMapping("/export")
    @ResponseBody
    public String exportFile(HttpServletResponse response) {
        List<ExcelUser> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExcelUser user = new ExcelUser();
            user.setUserName("wty" + i);
            user.setPassword("123456" + i);
            user.setAge("18");
            users.add(user);
        }
        try {
            ExcelUtils.exportExcel(users, null, "用户表", ExcelUser.class, "用户信息", response);
        } catch (IOException e) {
            e.printStackTrace();
            return "导出失败";
        }
        return "导出成功";
    }
    /**
     * 对象转换为Map<String, Object>的工具类
     *
     * @param obj 要转换的对象
     * @return
     * @throws IllegalAccessException
     */
    private static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>(16);
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            map.put(fieldName, value);
        }
        return map;
    }
}
