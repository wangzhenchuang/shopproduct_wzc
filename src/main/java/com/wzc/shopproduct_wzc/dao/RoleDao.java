package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleDao {

    @Select("select * from shop_role")
    public List<Role> queryRoleData();

}
