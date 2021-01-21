package com.wzc.shopproduct_wzc.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wzc.shopproduct_wzc.dao.ProductPropertyDataDao;
import com.wzc.shopproduct_wzc.dao.ShopProductDao;
import com.wzc.shopproduct_wzc.entity.po.ShopProduct;
import com.wzc.shopproduct_wzc.entity.po.ShopProductPropertyData;
import com.wzc.shopproduct_wzc.entity.vo.ProductParams;
import com.wzc.shopproduct_wzc.service.ShopProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ShopProductServiceImpl implements ShopProductService {

    @Resource
    private ShopProductDao shopProductDao;

    @Resource
    private ProductPropertyDataDao productPropertyDataDao;

    @Override
    public void addProduictData(ShopProduct product,String attr,String sku) {
        //第一步新增
        product.setCreateDate(new Date());
        product.setUpdateDate(new Date());
        product.setAuthor("admin");
        shopProductDao.add(product);

        //第二步新增 spu和sku的数据
        List<ShopProductPropertyData> dataList = new ArrayList<>();
        //把attr的json数组 转为json对象
        JSONArray objects = JSONObject.parseArray(attr);

        //循环spu数据
        for (int i = 0; i <objects.size() ; i++) {
            //构建属性数据对象
            ShopProductPropertyData ppd = new ShopProductPropertyData();
            //设置对应的数据
            ppd.setProId(product.getId());
            ppd.setAttrData(objects.get(i).toString());
            //将数据放到list集合中
             dataList.add(ppd);
        }

        //循环sku数据
        JSONArray parseArray = JSONObject.parseArray(sku);
        for (int i = 0; i <parseArray.size() ; i++) {
            //获取每一条数据
            JSONObject o = (JSONObject) parseArray.get(i);
            ShopProductPropertyData ppd1 = new ShopProductPropertyData();
            ppd1.setProId(product.getId());
            ppd1.setPrice(o.getInteger("price"));
            ppd1.setStorcks(o.getInteger("storcks"));
            o.remove("price");
            o.remove("storcks");
            ppd1.setAttrData(parseArray.get(i).toString());
            dataList.add(ppd1);
        }
      productPropertyDataDao.add(dataList);
    }

    @Override
    public Map queryProductPage(ProductParams params) {

        Map map = new HashMap();

        Long count = shopProductDao.queryProductByCount(params);
        map.put("count",count);
        List<ShopProduct> productList = shopProductDao.queryProductPage(params);
        map.put("list",productList);
        return map;
    }

    @Override
    public void updateProductData(ShopProduct product) {
        shopProductDao.updateProductData(product);
    }
}
