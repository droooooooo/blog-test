package com.my.blog.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {
    //文件上传工具类服务方法
    final static String filePath = "D:\\blog\\uploadimg\\";

    public static String uploadFile(MultipartFile file) throws Exception {

        String contentType = file.getContentType();   //图片文件类型
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();  //图片名字


        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file.getBytes());
        out.flush();
        out.close();

        return filePath + fileName;
    }
}
