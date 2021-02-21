package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.ShopPropertyValue;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.ShopPropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/propertyValue")
public class ShopPropertyValueController {


    @Autowired
    private ShopPropertyValueService shopPropertyValueService;

    @PostMapping("valueList")
    public ResultData  queryPropertyValue(Integer attrId){
        List<ShopPropertyValue> valueList = shopPropertyValueService.queryPropertyValue(attrId);
        return  ResultData.success(valueList);
    }

    @PostMapping("valueAdd")
    public  ResultData addPropertyValue(ShopPropertyValue propertyValue){

        shopPropertyValueService.addPropertyValue(propertyValue);
        return  ResultData.success(null);
    }

    @PostMapping("valueUpdate")
    public  ResultData updatePropertyValue(ShopPropertyValue shopPropertyValue){
        shopPropertyValueService.updatePropertyValue(shopPropertyValue);
        return  ResultData.success(null);
    }

    @PostMapping("delete")
    public  ResultData deletePropertyValue(Integer id){
        shopPropertyValueService.deletePropertyValue(id);
        return  ResultData.success(null);
    }

}
