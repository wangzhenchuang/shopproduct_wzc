package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.ShopUserDao;
import com.wzc.shopproduct_wzc.entity.po.ShopUser;
import com.wzc.shopproduct_wzc.service.ShopUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ShopUserServiceImpl implements ShopUserService {

    @Resource
    private ShopUserDao shopUserDao;

    @Override
    public void AddUserData(ShopUser user) {
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        shopUserDao.AddUserData(user);
    }

    @Override
    public List<ShopUser> queryUserByName(String name) {
        return shopUserDao.queryUserByName(name);
    }


}
