package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.QuanXian;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuanXianDao {

        @Select("select * from shop_quanxian where isDel=0")
        public List<QuanXian> queryQuanXianData();


}
