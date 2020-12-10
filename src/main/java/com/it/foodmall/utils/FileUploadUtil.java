package com.it.foodmall.utils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileUploadUtil {
    public static String uploadPhoto(MultipartFile photo) throws IOException {
        //处理文件名
        String originalFilename = photo.getOriginalFilename();
        String extension = "." + FilenameUtils.getExtension(originalFilename);
        String newName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date())+ UUID.randomUUID().toString().replaceAll("-","") + extension;
        //处理路径
        String path = "E:\\DataBasePhoto\\foodImg";
        //上传
        photo.transferTo(new File(path,newName));
        //返回路径保存到数据库中
        return path  + "\\" +  newName;
    }
    public static String uploadAvatar(MultipartFile avatar) throws IOException {
        //处理文件名
        String originalFilename = avatar.getOriginalFilename();
        String extension = "." + FilenameUtils.getExtension(originalFilename);
        String newName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date())+ UUID.randomUUID().toString().replaceAll("-","") + extension;
        //处理路径
        String path = "E:\\DataBasePhoto\\avatar";
        //上传
        avatar.transferTo(new File(path,newName));
        //返回路径保存到数据库中
        return path  + "\\" +  newName;
    }
}
