package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.ShopProperty;
import com.wzc.shopproduct_wzc.entity.vo.BrandParams;

import java.util.Map;

public interface ShopPropertyService {

    public Map  queryPropertyPage(BrandParams params);

    public  Integer addPropertyData(ShopProperty property);

}
