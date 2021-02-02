package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.RoleDao;
import com.wzc.shopproduct_wzc.entity.po.Role;
import com.wzc.shopproduct_wzc.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;


    @Override
    public List<Role> queryRoleData() {
        return roleDao.queryRoleData();
    }
}
