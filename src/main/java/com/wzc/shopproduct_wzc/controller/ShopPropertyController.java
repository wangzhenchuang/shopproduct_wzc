package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.ShopProperty;
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
    *    查询所有的属性数据
            路径  http://localhost:8080/api/property/propertyData

        post请求

        参数  start  size  (两个必填)

        返回值   {"code":200,"message":"提示",data:[{*}]}
    * */
    @PostMapping("propertyData")
    public ResultData queryPropertyData(BrandParams params){
        if (params.getStart()==null){
            return  ResultData.error(400,"参数不符合规则");
        }
        if (params.getSize()==null){
            return  ResultData.error(400,"参数不符合规则");
        }
        Map propertyPage = shopPropertyService.queryPropertyPage(params);
        return  ResultData.success(propertyPage);
    }

    /*
      * 新增属性数据

        路径   http://localhost:8080/api/property/add

       post请求

       参数

        返回值    {code:"",message:"",data:新增的id}
      * */
    //新增属性数据
    @PostMapping("add")
    public  ResultData  addPropertyData(ShopProperty shopProperty){
        shopPropertyService.addPropertyData(shopProperty);
        Integer id = shopProperty.getId();
        return ResultData.success(id);
    }

      /*
      * 根据id查找属性数据

        路径   http://localhost:8080/api/property/queryById

       post请求
       参数

        返回值    {code:"",message:"",data:null}
      * */
    //回显
    @GetMapping("queryById")
    public  ResultData  queryPropertyById(Integer id){
        if (id==null){
             return  ResultData.error(400,"参数不符合规则");
        }
        ShopProperty byId = shopPropertyService.querypropretyById(id);
        return  ResultData.success(byId);
    }

     /*
      * 根据id修改属性数据

        路径   http://localhost:8080/api/property/update

       post请求
       参数

        返回值    {code:"",message:"",data:null}
      * */
     @PostMapping("update")
     public  ResultData updatePropertyData(ShopProperty property){
         if (property.getId()==null){
               return  ResultData.error(400,"参数不符合规则");
         }
         shopPropertyService.updatePropertyData(property);
         return   ResultData.success(null);
     }


}
