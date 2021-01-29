package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.ShopUser;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.ShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        if (name!=null){
            return  ResultData.error(400,"账号已存在");
        }
        shopUserService.AddUserData(user);
        return  ResultData.success(null);
    }




}
