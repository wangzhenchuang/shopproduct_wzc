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
    * 参数 attr sku (必填)
    * 返回值 {code:"",message:"",data:null}
    * */


    @PostMapping("add")
    public ResultData  addproductData(ShopProduct product,String attr,String sku){
        if (attr==null){
            return  ResultData.error(400,"spu的数据不能为空");
        }
        if (sku==null){
            return  ResultData.error(400,"sku的数据不能为空");
        }
        shopProductService.addProduictData(product,attr,sku);
        return  ResultData.success(null);
    }



}
