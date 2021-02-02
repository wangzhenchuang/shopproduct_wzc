package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RoleDao {

    @Select("select * from shop_role")
    public List<Role> queryRoleData();

    @Insert("insert into shop_role (name,isDel,createDate,updateDate,author) value (#{name},#{isDel},#{createDate},#{updateDate},#{author})")
    public  void addRoleData(Role role);




}
