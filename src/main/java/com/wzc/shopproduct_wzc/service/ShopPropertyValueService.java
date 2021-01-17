package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.ShopPropertyValue;

import java.util.List;

public interface ShopPropertyValueService {

    public List<ShopPropertyValue> queryPropertyValue(Integer attrId);

    public  void addPropertyValue(ShopPropertyValue propertyValue);

}
