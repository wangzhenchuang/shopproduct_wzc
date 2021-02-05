package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.entity.vo.UserParams;
import com.wzc.shopproduct_wzc.service.ShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/user")
@CrossOrigin
public class ShopUserController {


    @Autowired
    private ShopUserService shopUserService;


     /*
     * 查询用户数据的接口文档
     * 路径  http://localhost:8080/api/user/list
     *
     * 请求方式  post
     *
     * 参数  start  size (必填)
     *
     * 返回值 回值    {code:"",message:"",data:map}
     * */
    @PostMapping("list")
    public ResultData  queryUserData(UserParams params){
        if (params.getSize()==null){
            return  ResultData.error(400,"参数不符合规则");
        }
        if (params.getStart()==null){
            return  ResultData.error(400,"参数不符合规则");
        }

        Map map = shopUserService.queryUserData(params);
        return  ResultData.success(map);
    }


}
