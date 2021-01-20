package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.ShopProductDao;
import com.wzc.shopproduct_wzc.entity.po.ShopProduct;
import com.wzc.shopproduct_wzc.service.ShopProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopProductServiceImpl implements ShopProductService {

    @Resource
    private ShopProductDao shopProductDao;

    @Override
    public void addProduictData(ShopProduct product) {
        shopProductDao.add(product);
    }
}
