package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.ShopPropertyValueDao;
import com.wzc.shopproduct_wzc.entity.po.ShopPropertyValue;
import com.wzc.shopproduct_wzc.service.ShopPropertyValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ShopPropertyValueServiceImpl implements ShopPropertyValueService {

    @Resource
    private ShopPropertyValueDao shopPropertyValueDao;


    @Override
    public List<ShopPropertyValue> queryPropertyValue(Integer attrId) {
        List<ShopPropertyValue> shopPropertyValues = shopPropertyValueDao.queryPropertyValue(attrId);
        return shopPropertyValues;
    }

    @Override
    public void addPropertyValue(ShopPropertyValue propertyValue) {
        shopPropertyValueDao.addPropertyValue(propertyValue);
    }
}
