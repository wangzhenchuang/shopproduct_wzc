package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.ShopPropertyDao;
import com.wzc.shopproduct_wzc.entity.po.ShopProperty;
import com.wzc.shopproduct_wzc.entity.vo.BrandParams;
import com.wzc.shopproduct_wzc.service.ShopPropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ShopPropertyServiceImpl  implements ShopPropertyService {

    @Resource
    private ShopPropertyDao shopPropertyDao;

    @Override
    public Map queryPropertyPage(BrandParams params) {

        Map map = new HashMap();
        Long count = shopPropertyDao.queryPropertyByCount(params);
        map.put("count",count);
        List<ShopProperty> shopProperties = shopPropertyDao.queryPropertyPage(params);
        map.put("list",shopProperties);
        return map;
    }

    //新增属性数据
    @Override
    public Integer addPropertyData(ShopProperty property) {
        property.setAuthor("admin");
        property.setCreateDate(new Date());
        Integer addPropertyData = shopPropertyDao.addPropertyData(property);
        return  addPropertyData;
    }
}
