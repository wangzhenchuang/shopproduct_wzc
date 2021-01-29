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
    public void addProduictData(ShopProduct product, String attr, String sku) {
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
        for (int i = 0; i < objects.size(); i++) {
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
        for (int i = 0; i < parseArray.size(); i++) {
            //获取每一条数据
            JSONObject o = (JSONObject) parseArray.get(i);
            ShopProductPropertyData ppd1 = new ShopProductPropertyData();
            ppd1.setProId(product.getId());
            ppd1.setPrice(o.getInteger("price"));
            ppd1.setStorcks(o.getInteger("storcks"));
          /* 不需要移除了
           o.remove("price");
            o.remove("storcks");*/
            ppd1.setAttrData(parseArray.get(i).toString());
            dataList.add(ppd1);
        }
        productPropertyDataDao.add(dataList);
    }

    @Override
    public Map queryProductPage(ProductParams params) {

        Map map = new HashMap();

        Long count = shopProductDao.queryProductByCount(params);
        map.put("count", count);
        List<ShopProduct> productList = shopProductDao.queryProductPage(params);
        map.put("list", productList);
        return map;
    }

    @Override
    public void updateProductData(ShopProduct product) {
        shopProductDao.updateProductData(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        shopProductDao.deleteProduct(id);
    }

    @Override
    public List<ShopProductPropertyData> querydata(Integer proId) {
        return productPropertyDataDao.querydata(proId);
    }

    @Override
    public Map querySKUAndAttrCkvalues(Integer proId) {
        Map data = new HashMap();
        // 查询所有的数据
        List<ShopProductPropertyData> productAttrDatas = productPropertyDataDao.querydata(proId);
        //sku的数据  {"memsize":["32g"],"color":['红色','绿色'],"netType":'联通'}
        Map skuData = new HashMap();
        Map attrData = new HashMap();
        Map tableData = new HashMap();
        List<JSONObject> tableList = new ArrayList<>();
        //遍历所有数据
        for (int i = 0; i < productAttrDatas.size(); i++) {
            //得到具体的一个属性数据
            ShopProductPropertyData propertyData = productAttrDatas.get(i);
            //判断此属性为那种属性
            if (propertyData.getPrice() != null) { //是sku属性   这种判断不严谨
                //得到对应数据的json字符串 {"memsize":"32G","pricess":111,"color":"红色","netType":"联通","storcks":111}
                //得到对应数据的json字符串 {"memsize":"32G","pricess":111,"color":"红色","netType":"联通","storcks":111}
                //将字符串转为json对象  引入fastjson工具类
                JSONObject jsonObject = JSONObject.parseObject(propertyData.getAttrData());
                //遍历jsonobject
                Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
                for (Map.Entry<String, Object> entry : entries) {
                    String key = entry.getKey();//color
                    //判断skuData中是否有此属性
                    Set values = (Set) skuData.get(key);
                    if (values != null) {
                        values.add(entry.getValue());
                    } else {
                        //创建一个set 集合
                        Set valuesSet = new HashSet();
                        valuesSet.add(entry.getValue());
                        skuData.put(key, valuesSet);
                    }
                }
                //表格属性放入list
                tableList.add(jsonObject);

            } else {
                //得到对应数据的json字符串  {"factory":"苹果尝试"}
                JSONObject obj = JSONObject.parseObject(propertyData.getAttrData());
                Set<Map.Entry<String, Object>> entries = obj.entrySet();
                for (Map.Entry<String, Object> entry : entries) {
                    attrData.put(entry.getKey(), entry.getValue());
                }
            }


        }
        //将sku 和attr 放入返回值中
        data.put("skudata", skuData);
        data.put("attrdata", attrData);
        data.put("tableData", tableList);
        return data;
    }

}
