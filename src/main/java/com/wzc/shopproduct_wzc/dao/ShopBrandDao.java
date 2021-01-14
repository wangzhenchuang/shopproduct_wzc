package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.ShopBrand;
import com.wzc.shopproduct_wzc.entity.vo.BrandParams;

import java.util.List;

public interface ShopBrandDao {

    //品牌数据总条数
    public  Long  queryBrandByCount(BrandParams params);

    //分页查询品牌数据
    public List<ShopBrand> queryBrandPage(BrandParams params);

    //新增
    public   void  addBrandData(ShopBrand shopBrand);

    //修改
    public   void  updateBrandData(ShopBrand shopBrand);

    //回显
    public  ShopBrand  queryBrandById(Integer id);

    //删除
     public  void  deleteBrandData(Integer id);

}
