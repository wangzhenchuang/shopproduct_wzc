package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.ShopUser;
import com.wzc.shopproduct_wzc.entity.vo.UserParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShopUserDao {


    @Insert("insert into shop_user (name,realName,password,sex,phone,email,idCard,birthday,imgUrl,eduId,deptId,createDate,updateDate,isDel)" +
            " value (#{name},#{realName},#{password},#{sex},#{phone},#{email},#{idCard},#{birthday},#{imgUrl},#{eduId},#{deptId},#{createDate},#{updateDate},#{isDel})")
    public  void AddUserData(ShopUser user);

    @Select("select * from shop_user where name=#{name}")
    public ShopUser queryUserByName(String name);


    public   Long  queryUserByCount(UserParams params);

    public  List<ShopUser> queryUserDataByPage(UserParams params);

    @Update("update shop_user set realName=#{realName},sex=#{sex},phone=#{phone},email=#{email},birthday=#{birthday},imgUrl=#{imgUrl}" +
            ",eduId=#{eduId},deptId=#{deptId},updateDate=#{updateDate} where id=#{id}")
    public  void  updateUserData(ShopUser user);

    @Update("update shop_user set isDel=1 where id=#{id}")
    public  void deleteUserData(Integer id);

}
