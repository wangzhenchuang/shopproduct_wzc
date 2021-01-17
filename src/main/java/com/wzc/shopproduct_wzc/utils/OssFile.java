package com.wzc.shopproduct_wzc.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.InputStream;

public class OssFile {

     // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
    private static   String accessKeyId = "LTAI4GL12kVdLWLK4g8zPwTo";
    private static  String accessKeySecret = "7DQo2PwSM7mmm1VwGE2kh7C5k2ZPD4";
    private static String bucket="feihu-wzc";

    //  is 输入流  fileName  保存的名字   可以包含路径
    public  static String uploadFile(InputStream is,String fileName){

        // 下载jar包

        //创建工具类

        //创建OSSClient实例。
        OSS build = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //调用上传得方法
        build.putObject(bucket,fileName,is);
        //判断是否上传成功
        //释放资源
        build.shutdown();
        //返回文件的存储路径
        return  "https://"+bucket+"."+endpoint+"/"+fileName;

    }


}
