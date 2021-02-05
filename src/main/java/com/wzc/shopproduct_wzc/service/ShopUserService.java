package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.ShopUser;
import com.wzc.shopproduct_wzc.entity.vo.UserParams;

import java.util.List;
import java.util.Map;

public interface ShopUserService {

    public void  AddUserData(ShopUser user);

    public  ShopUser queryUserByName(String name);

    public Map  queryUserData(UserParams params);
}
