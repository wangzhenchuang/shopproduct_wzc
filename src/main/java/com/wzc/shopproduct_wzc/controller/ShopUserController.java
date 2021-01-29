package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.ShopUser;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.ShopUserService;
import com.wzc.shopproduct_wzc.utils.Md5Utils;
import com.wzc.shopproduct_wzc.utils.OssFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/user")
@CrossOrigin
public class ShopUserController {


    @Autowired
    private ShopUserService shopUserService;



    /*
    * 注册的接口文档
    * 路径  http://localhost:8080/api/user/zhuce
    *
    * 请求方式  post
    *
    * 参数
    *
    * 返回值 回值    {code:"",message:"",data:}
    * */
    @PostMapping("zhuce")
    public ResultData  adduser(ShopUser user){
       List<ShopUser> name = shopUserService.queryUserByName(user.getName());
        if (name==null){
            return  ResultData.error(400,"账号已存在");
        }
        String md5 = Md5Utils.MD5(Md5Utils.MD5(user.getPassword()) + Md5Utils.MD5(user.getName()));
        user.setPassword(md5);
        shopUserService.AddUserData(user);
        return  ResultData.success(null);
    }

 /*   图片上传
    *请求路径 : http://localhost:8080/api/user/upload
    *
    *请求方式 post
    *
    *返回值
     * Code(200);成功回调函数
     * Message("success");返回值
     * Data(data);数据
    *
    * 参数
    *  file  必填
    * */
    //图片上传
    @PostMapping("upload")
    public  ResultData upload(MultipartFile file) throws IOException {
        //处理新名称
        String originalFilename = file.getOriginalFilename();
        //防止重命名
        String newName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //存储路径
        newName="imgUrl/"+newName;
        String file1 = OssFile.uploadFile(file.getInputStream(), newName);
        return  ResultData.success(file1);
    }


}
