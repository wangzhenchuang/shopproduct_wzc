package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.ShopUser;

import java.util.List;

public interface ShopUserService {

    public void  AddUserData(ShopUser user);

    public  ShopUser queryUserByName(String name);
}
