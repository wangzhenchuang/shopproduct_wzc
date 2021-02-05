package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.ShopUserDao;
import com.wzc.shopproduct_wzc.entity.po.ShopUser;
import com.wzc.shopproduct_wzc.entity.vo.UserParams;
import com.wzc.shopproduct_wzc.service.ShopUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopUserServiceImpl implements ShopUserService {

    @Resource
    private ShopUserDao shopUserDao;

    //用户注册
    @Override
    public void AddUserData(ShopUser user) {
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        shopUserDao.AddUserData(user);
    }
    //用户登录和验证用户名唯一
    @Override
    public ShopUser queryUserByName(String name) {
        return shopUserDao.queryUserByName(name);
    }

    //查询用户数据
    @Override
    public Map queryUserData(UserParams params) {
        Map  map = new HashMap();
        Long count = shopUserDao.queryUserByCount(params);
        map.put("count",count);

        List<ShopUser> userList = shopUserDao.queryUserDataByPage(params);
        map.put("list",userList);

        return map;
    }


}
