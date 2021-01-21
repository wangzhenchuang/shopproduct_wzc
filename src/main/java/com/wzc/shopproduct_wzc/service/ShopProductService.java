package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.ShopProduct;
import com.wzc.shopproduct_wzc.entity.vo.ProductParams;

import java.util.Map;

public interface ShopProductService {

    public  void addProduictData(ShopProduct product,String attr,String sku);

    public Map  queryProductPage(ProductParams params);


    public  void updateProductData(ShopProduct product);

    public  void deleteProduct(Integer id);

}
