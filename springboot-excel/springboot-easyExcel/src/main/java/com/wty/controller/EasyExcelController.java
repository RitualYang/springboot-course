package com.wty.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.wty.model.UserExcel;
import com.wty.model.UserInfoModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.compress.utils.Lists;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * easyExcel测试接口
 *
 * @author wty
 * @date 2020/8/24 10:30
 */
@RestController
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

    @PostMapping("/upload")
    public String upload(@RequestPart(value = "file")MultipartFile file) throws IOException {
        String filePath = file.getOriginalFilename();
        if (StringUtils.isEmpty(filePath) || !(filePath.endsWith(".csv") || filePath.endsWith(".xls") || filePath.endsWith(".xlsx"))) {
            System.out.println("upload error :" + filePath);
            return "error";
        }
        ArrayList<String> strings = Lists.newArrayList();
        AtomicLong fileSize = new AtomicLong(0);
        ArrayList<String> filePaths = Lists.newArrayList();
        // 读取file
        ExcelReaderBuilder builder = EasyExcelFactory.read(file.getInputStream(), UserInfoModel.class, new AnalysisEventListener<UserInfoModel>() {
            @Override
            public void invoke(UserInfoModel o, AnalysisContext analysisContext) {
                // 根据长度写入新file文件中
                strings.add(o.getId());
                fileSize.getAndAdd(o.getId().getBytes(StandardCharsets.UTF_8).length);
                if (fileSize.get() > 0.80 * 1024 * 1024) {
                    // 推送到s3 环境
                    try {
                        filePaths.add(saveToS3(strings));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    strings.clear();
                    fileSize.set(0);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        });
        if (filePath.endsWith(".csv")) {
            builder.excelType(ExcelTypeEnum.CSV);
        }
        builder.sheet().doRead();
        if (!CollectionUtils.isEmpty(strings)) {
            filePaths.add(saveToS3(strings));
        }
        return "DONE";
    }

    private String saveToS3(List<String> strings) throws IOException {
        File file = new File(strings.get(0) + "txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        strings.forEach(st ->
                {
                    try {
                        bw.write(st);
                        bw.newLine();
                        bw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            );
            bw.close();
        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), fileInputStream);
        System.out.println("multipartFile:" + multipartFile.getSize());
        file.delete();
        return "";
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
