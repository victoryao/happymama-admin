package com.happymama.admin.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by yaoqiang on 2018/3/21.
 */
public class FileUtils {

    static final String BASE_PATH = "/haoayi/imgs/";

    public static String saveFile(MultipartFile photo) throws IOException {
        if (!photo.isEmpty()) {

            String originalFileName = photo.getOriginalFilename();
            // 新的图片名称
            String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
            // 新的图片
            String path = BASE_PATH + newFileName;
            File newFile = new File(path);
            // 将内存中的数据写入磁盘
            photo.transferTo(newFile);
            return path;
        }
        return "";
    }
}
