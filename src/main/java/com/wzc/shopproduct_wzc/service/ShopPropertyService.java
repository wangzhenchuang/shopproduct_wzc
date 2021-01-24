package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.ShopProperty;
import com.wzc.shopproduct_wzc.entity.vo.BrandParams;

import java.util.List;
import java.util.Map;

public interface ShopPropertyService {

    public Map  queryPropertyPage(BrandParams params);

    public  Integer addPropertyData(ShopProperty property);

    public  ShopProperty  querypropretyById(Integer id);

    public   void  updatePropertyData(ShopProperty property);

     public  void deletePropertyData(Integer id);

     public List<ShopProperty> queryPropertyBytyid(Integer typeid);

     public Map  queryPropertyDataByTypeId(Integer typeId);

}
