package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.ShopProductPropertyData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductPropertyDataDao {


    @Insert("<script>" +
            "insert into shop_product_data (proId,attrData,storcks,price) " +
            "values <foreach collection='list' item='a' separator=','>" +
            " ( #{a.proId},#{a.attrData},#{a.storcks},#{a.price} )  " +
            "</foreach> </script>")
    public void add(List<ShopProductPropertyData> productPropertyData);
}
