package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptDao {

    @Select("select * from shop_dept")
    public List<Dept> queryDeptData();

}
