package com.happymama.admin.utils;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by yaoqiang on 2018/7/30.
 */

@Slf4j
public class FileUploadUtil {

    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAIVz6W5g7AzUPz";
    private static String accessKeySecret = "PYC94GMjyIBSmuKS6ceSkqDMR6T3U6";
    private static String bucketName = "happymama";
    private static OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

    public static void uploadImg(String imgName, InputStream is) {
        ossClient.putObject(bucketName, imgName, is);
    }

    public static String getImgUrl(String imgName) {
        String style = "image/resize,m_fixed,w_550";
        GetObjectRequest request = new GetObjectRequest(bucketName, imgName);
        request.setProcess(style);
        OSSObject metadata = ossClient.getObject(request);
        return metadata.getResponse().getUri();
    }



}
