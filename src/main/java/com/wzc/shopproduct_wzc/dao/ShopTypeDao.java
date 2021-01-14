package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.ShopType;

import java.util.List;
import java.util.Map;

public interface ShopTypeDao {

    //分类管理数据查询
   public List<ShopType> queryShopTypeList();
    
    

    //根据ID查询分类数据
    public  ShopType  queryShopTypeByPid(Integer pid);

    //新增分类的数据
    public  Integer addShopTypeData(ShopType shopType);

    //修改分类的数据
    public  void updateShopTypeData(ShopType shopType);

    public  void deleteShopData(Integer id);

    //List<Map<String, Object>> queryShopTypeList();
}
