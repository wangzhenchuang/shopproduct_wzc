package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.ShopProperty;
import com.wzc.shopproduct_wzc.entity.vo.BrandParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ShopPropertyDao {

    //查询属性总条数
    public  Long  queryPropertyByCount(BrandParams params);
    //查询属性分页数据
    public List<ShopProperty> queryPropertyPage(BrandParams params);

    //新增属性数据
    public  Integer addPropertyData(ShopProperty property);

    //修改 回显数据
    public  ShopProperty querypropretyById(Integer id);

    public  void updatePropertyData(ShopProperty property);

    public  void  deletePropertyData(Integer id);

    //根据typeId查询数据
    @Select("select * from shop_property where typeId=#{typeid} and isDel=0")
    public List<ShopProperty>  queryPropertyBytyid(Integer typeid);

}
