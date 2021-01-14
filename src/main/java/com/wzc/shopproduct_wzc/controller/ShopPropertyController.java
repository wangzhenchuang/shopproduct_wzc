package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.vo.BrandParams;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.ShopPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/property")
public class ShopPropertyController {

    @Autowired
    private ShopPropertyService shopPropertyService;

    /*
    *
    *    查询所有的品牌数据
            路径  http://localhost:8080/api/property/propertyData

        post请求

        参数  start  size  (两个必填)

        返回值   {"code":200,"message":"提示",data:[{*}]}
    * */
    @PostMapping("propertyData")
    public ResultData queryPropertyData(BrandParams params){
        Map propertyPage = shopPropertyService.queryPropertyPage(params);
        return  ResultData.success(propertyPage);
    }



}
