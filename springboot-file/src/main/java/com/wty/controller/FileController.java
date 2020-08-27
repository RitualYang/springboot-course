package com.wty.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * TODO
 *
 * @author WTY
 * @Date 2020/8/26 17:17
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        log.info("上传文件信息:{}",fileName);
        return "上传成功";
    }
    @PostMapping("/uploads")
    public String fileUpload(@RequestParam("files")MultipartFile[] files){
        if (files == null || files.length == 0){
            return "上传失败,请重新选择文件";
        }
        // 多文件上传
        for (MultipartFile file : files){
            String originalFilename = file.getOriginalFilename();
            log.info("文件名:{}",originalFilename);
        }
        return "上传成功";
    }

}
