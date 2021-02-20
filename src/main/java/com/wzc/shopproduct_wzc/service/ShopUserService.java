package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.ShopUser;
import com.wzc.shopproduct_wzc.entity.po.ShopUserRole;
import com.wzc.shopproduct_wzc.entity.vo.UserParams;

import java.util.List;
import java.util.Map;

public interface ShopUserService {

    public void  AddUserData(ShopUser user);

    public  ShopUser queryUserByName(String name);

    public Map  queryUserData(UserParams params);

    public  void updateUserData(ShopUser user);

    public  void deleteUserData(Integer id);


    public  void addUserRoleData(Integer uid,String rid);

    public List<ShopUserRole> queryUserRoleByUid(Integer uid);

}
