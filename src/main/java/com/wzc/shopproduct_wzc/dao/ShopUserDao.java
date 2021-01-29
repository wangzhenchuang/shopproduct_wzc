package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.ShopUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopUserDao {


    @Insert("insert into shop_user (name,realName,password,sex,phone,email,idCard,birthday,ingUrl,eduld,deptId,createDate,updateDate)" +
            " value (#{name},#{realName},#{password},#{sex},#{phone},#{email},#{idCard},#{birthday},#{ingUrl},#{eduld},#{deptId},#{createDate},#{updateDate})")
    public  void AddUserData(ShopUser user);

    @Select("select * from shop_user where name=#{name}")
    public List<ShopUser> queryUserByName(String name);



}
