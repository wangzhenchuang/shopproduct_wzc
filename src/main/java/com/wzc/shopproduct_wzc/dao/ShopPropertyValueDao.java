package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.ShopPropertyValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ShopPropertyValueDao {

    @Select("select * from shop_property_value where proId=#{attrId}")
    public List<ShopPropertyValue> queryPropertyValue(Integer attrId);

    @Insert("insert into shop_property_value (value,valueCh,proId) value (#{value},#{valueCh},#{proId})")
    public  void  addPropertyValue(ShopPropertyValue propertyValue);


}
