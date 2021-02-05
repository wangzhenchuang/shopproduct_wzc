package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.XueLi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface XueLiDao {

    @Select("select * from shop_xueLi where 1=1")
    public List<XueLi> queryXueLiData();

}
