package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.ShopType;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;

import java.util.List;

public interface ShopTypeService {

    public List<ShopType> queryShopTypeList();

    public  ShopType queryShopTypeByPid(Integer pid);

    public  Integer addShopTypeData(ShopType shopType);

    public  void updateShopTypeData(ShopType shopType);

    public  void deleteShopData(Integer id);

}
