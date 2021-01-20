package com.wzc.shopproduct_wzc.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.wzc.shopproduct_wzc.dao.ShopTypeDao;
import com.wzc.shopproduct_wzc.entity.po.ShopType;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.ShopTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ShopTypeServiceImpl implements ShopTypeService {

    @Resource
    private ShopTypeDao shopTypeDao;

    //分类管理数据查询
    @Override
    public List<ShopType> queryShopTypeList() {
        List<ShopType> shopTypeList = shopTypeDao.queryShopTypeList();
        return shopTypeList;
    }



    //根据ID查询分类数据
    @Override
    public ShopType queryShopTypeByPid(Integer pid) {
        ShopType byId = shopTypeDao.queryShopTypeByPid(pid);
        return byId;
    }
    //新增分类数据
    @Override
    public Integer addShopTypeData(ShopType shopType) {
        shopType.setCreateDate(new Date());
        shopType.setIsDel(0);
        shopType.setOperator("admin");
      return   shopTypeDao.addShopTypeData(shopType);
    }

    @Override
    public void updateShopTypeData(ShopType shopType) {
            shopType.setUpdateDate(new Date());
            shopType.setIsDel(0);
            shopType.setOperator("admin");
            shopTypeDao.updateShopTypeData(shopType);
    }

    @Override
    public void deleteShopData(Integer id) {
        shopTypeDao.deleteShopData(id);
    }
}
