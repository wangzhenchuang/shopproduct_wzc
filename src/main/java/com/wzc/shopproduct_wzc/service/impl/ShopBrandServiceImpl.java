package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.ShopBrandDao;
import com.wzc.shopproduct_wzc.entity.po.ShopBrand;
import com.wzc.shopproduct_wzc.entity.vo.BrandParams;
import com.wzc.shopproduct_wzc.service.ShopBrandService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ShopBrandServiceImpl implements ShopBrandService {

    @Resource
    private ShopBrandDao shopBrandDao;

    @Override
    public Map queryBrandPage(BrandParams params) {

        Map map = new HashMap();

        Long count = shopBrandDao.queryBrandByCount(params);
        map.put("count",count);
        List<ShopBrand> shopBrands = shopBrandDao.queryBrandPage(params);
        map.put("list",shopBrands);

        return map;
    }

    @Override
    public void addBrandData(ShopBrand shopBrand) {
        shopBrand.setCreateDate(new Date());
        shopBrand.setIsDel(0);
        shopBrand.setAuthor("admin");
        shopBrandDao.addBrandData(shopBrand);
    }

    @Override
    public void updateBrandData(ShopBrand shopBrand) {
        shopBrand.setUpdateDate(new Date());
        shopBrand.setIsDel(0);
        shopBrand.setAuthor("admin");
        shopBrandDao.updateBrandData(shopBrand);
    }

    @Override
    public void deleteBrandData(Integer id) {
        shopBrandDao.deleteBrandData(id);
    }

    @Override
    public ShopBrand queryBrandById(Integer id) {
        return shopBrandDao.queryBrandById(id);
    }


}
