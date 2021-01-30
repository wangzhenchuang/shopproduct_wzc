package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.QuanXian;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface QuanXianDao {


        @Select("select * from shop_quanxian where isDel=0")
        public List<QuanXian> queryQuanXianData();

        @Insert("insert into shop_quanxian (pid,name,url,type,isDel,createDate,updateDate,author)" +
                "value (#{pid},#{name},#{url},#{type},#{isDel},#{createDate},#{updateDate},#{author})")
        public  void  addQuanXianData(QuanXian quanXian);

        @Update(" update shop_quanxian set pid=#{pid},name=#{name},url=#{url},type=#{type},isDel=#{isDel},updateDate=#{updateDate},author=#{author} where id=#{id}")
        public  void  updateQuanXianData(QuanXian quanXian);

        @Update("update shop_quanxian set isDel=1 where id=#{id}")
        public  Integer  deleteQuanXianData(Integer id);


}
