package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.ShopPropertyDao;
import com.wzc.shopproduct_wzc.dao.ShopPropertyValueDao;
import com.wzc.shopproduct_wzc.entity.po.ShopProperty;
import com.wzc.shopproduct_wzc.entity.po.ShopPropertyValue;
import com.wzc.shopproduct_wzc.entity.vo.BrandParams;
import com.wzc.shopproduct_wzc.service.ShopPropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ShopPropertyServiceImpl implements ShopPropertyService {

    @Resource
    private ShopPropertyDao shopPropertyDao;

    @Resource
    private ShopPropertyValueDao propertyValueDao;

    @Override
    public Map queryPropertyPage(BrandParams params) {

        Map map = new HashMap();
        Long count = shopPropertyDao.queryPropertyByCount(params);
        map.put("count", count);
        List<ShopProperty> shopProperties = shopPropertyDao.queryPropertyPage(params);
        map.put("list", shopProperties);
        return map;
    }

    //新增属性数据
    @Override
    public Integer addPropertyData(ShopProperty property) {
        property.setAuthor("admin");
        property.setCreateDate(new Date());
        property.setUpdateDate(new Date());
        Integer addPropertyData = shopPropertyDao.addPropertyData(property);
        return addPropertyData;
    }

    @Override
    public ShopProperty querypropretyById(Integer id) {
        return shopPropertyDao.querypropretyById(id);
    }

    @Override
    public void updatePropertyData(ShopProperty property) {
        property.setAuthor("admin");
        property.setUpdateDate(new Date());
        shopPropertyDao.updatePropertyData(property);
    }

    @Override
    public void deletePropertyData(Integer id) {
        shopPropertyDao.deletePropertyData(id);
    }

    //根据typeid查询属性数据
    @Override
    public List<ShopProperty> queryPropertyBytyid(Integer typeid) {
        return shopPropertyDao.queryPropertyBytyid(typeid);
    }

    //查询属性值数据
    @Override
    public Map queryPropertyDataByTypeId(Integer typeId) {

        Map map = new HashMap();
        //查询所有属性数据
        List<ShopProperty> properties = shopPropertyDao.queryPropertyBytyid(typeId);
        //sku数据
        List<ShopProperty> skuData = new ArrayList<>();
        //非sku数据
        List<ShopProperty> attrData = new ArrayList<>();

        for (int i = 0; i < properties.size(); i++) {
            ShopProperty property = properties.get(i);
            //判断是否为sku
            if (property.getIsSKU() == 0) {
                if (property.getType() != 3) {
                    List<ShopPropertyValue> values = propertyValueDao.queryPropertyValue(property.getId());
                    property.setValues(values);
                }
                attrData.add(property);
            } else {
                if (property.getType() != 3) {
                    List<ShopPropertyValue> values = propertyValueDao.queryPropertyValue(property.getId());
                    property.setValues(values);
                }
                skuData.add(property);
            }
        }
        map.put("attrData", attrData);
        map.put("skuData", skuData);
        return map;
    }
}
