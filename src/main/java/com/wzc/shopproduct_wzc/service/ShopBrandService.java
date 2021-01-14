package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.ShopBrand;
import com.wzc.shopproduct_wzc.entity.vo.BrandParams;

import java.util.List;
import java.util.Map;

public interface ShopBrandService {

    public Map  queryBrandPage(BrandParams params);

    public  void addBrandData(ShopBrand shopBrand);

    public  void updateBrandData(ShopBrand shopBrand);

    public  void  deleteBrandData(Integer id);

    public  ShopBrand queryBrandById(Integer id);

}
