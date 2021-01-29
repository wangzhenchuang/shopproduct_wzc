package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.ShopProduct;
import com.wzc.shopproduct_wzc.entity.po.ShopProductPropertyData;
import com.wzc.shopproduct_wzc.entity.vo.ProductParams;

import java.util.List;
import java.util.Map;

public interface ShopProductService {

    public  void addProduictData(ShopProduct product,String attr,String sku);

    public Map  queryProductPage(ProductParams params);


    public  void updateProductData(ShopProduct product);

    public  void deleteProduct(Integer id);

    //查询商品属性值
    public List<ShopProductPropertyData> querydata(Integer proId);

    //查询属性值
     // {skudata, attrdata,tableData}
    public Map querySKUAndAttrCkvalues(Integer proId);

}
