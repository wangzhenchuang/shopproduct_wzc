package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.RoleDao;
import com.wzc.shopproduct_wzc.entity.po.Role;
import com.wzc.shopproduct_wzc.entity.vo.RoleParams;
import com.wzc.shopproduct_wzc.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;


    @Override
    public Map queryRoleDataPage(RoleParams params) {
        Map map = new HashMap();
        Long count = roleDao.queryRoleByCount(params);
        map.put("count",count);
        List<Role> roleList = roleDao.queryRoleDataPage(params);
        map.put("list",roleList);
        return map;
    }

    @Override
    public void addRoleData(Role role) {
        role.setCreateDate(new Date());
        role.setUpdateDate(new Date());
        roleDao.addRoleData(role);
    }

    @Override
    public void updateRoleData(Role role) {
        role.setUpdateDate(new Date());
        roleDao.updateRoleData(role);
    }

    @Override
    public void deleteRoleData(Integer id) {
        roleDao.deleteRoleData(id);
    }
}
