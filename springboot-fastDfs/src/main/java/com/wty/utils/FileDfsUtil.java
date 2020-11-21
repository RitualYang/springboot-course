package com.wty.utils;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;

/**
 * fastDFS工具类
 *
 * @author: wty
 * @date: 2019/12/06 15:15
 **/
@Component
@Slf4j
public class FileDfsUtil {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    /**
     * @param file 文件对象
     * @return 文件路径
     * @throws IOException String
     * @Description: 上传文件
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(),
                FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return storePath.getFullPath();
    }

    /**
     * @param bytes  文件数据
     * @param format 文件格式(后缀)
     * @return String 文件路径
     * @Description: 上传文件
     */
    public String uploadFile(byte[] bytes, String format) {
        StorePath storePath = storageClient.uploadFile(new ByteArrayInputStream(bytes), bytes.length, format, null);
        return storePath.getFullPath();
    }

    /**
     * @param file 文件对象
     * @return
     * @throws IOException String
     * @Description: 上传文件
     */
    public String uploadFile(File file) throws IOException {
        StorePath storePath = storageClient.uploadFile(FileUtils.openInputStream(file), file.length(),
                FilenameUtils.getExtension(file.getName()), null);
        return storePath.getFullPath();
    }

    /**
     * @param content
     * @param fileExtension
     * @return String
     * @Description: 把字符串作为指定格式的文件上传
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream, buff.length, fileExtension, null);
        return storePath.getFullPath();
    }

    /**
     * @param file 文件对象
     * @return 文件路径
     * @throws IOException String
     * @Description: 上传文件
     */
    public String uploadImageAndCrtThumbImage(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(),
                FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return storePath.getFullPath();
    }

    /**
     * @param filePath 图片路径
     * @return String 缩略图路径
     * @Description: 根据图片路径获取缩略图路径(使用uploadImageAndCrtThumbImage方法上传图片)
     */
    public String getThumbImagePath(String filePath) {
        return thumbImageConfig.getThumbImagePath(filePath);
    }

    /**
     * @param filePath 文件路径
     * @return 文件字节数据
     * @throws IOException byte[]
     * @Description: 根据文件路径下载文件
     */
    public byte[] downFile(String filePath) throws IOException {
        StorePath storePath = StorePath.parseFromUrl(filePath);
        return storageClient.downloadFile(storePath.getGroup(), storePath.getPath(), new DownloadCallback<byte[]>() {
            @Override
            public byte[] recv(InputStream ins) throws IOException {
                return org.apache.commons.io.IOUtils.toByteArray(ins);
            }
        });
    }

    /**
     * @param filePath 文件访问地址
     * @Description: 根据文件地址删除文件
     */
    public void deleteFile(String filePath) {
        StorePath storePath = StorePath.parseFromUrl(filePath);
        storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
    }
}
