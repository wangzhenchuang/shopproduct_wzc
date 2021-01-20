package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.ShopProduct;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.ShopProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/product")
public class ShopProductController {

    @Autowired
    private ShopProductService shopProductService;

    /*
        新增商品的接口
    *
    * 请求路径 http://localhost:8080/api/product/add
    * 请求方式 post
    *
    * 返回值 {code:"",message:"",data:null}
    * */


    @PostMapping("add")
    public ResultData  addproductData(ShopProduct product){
        shopProductService.addProduictData(product);
        return  ResultData.success(null);
    }


}
