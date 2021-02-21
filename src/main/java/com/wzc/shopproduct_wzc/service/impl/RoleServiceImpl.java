package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.RoleDao;
import com.wzc.shopproduct_wzc.entity.po.Role;
import com.wzc.shopproduct_wzc.entity.po.RoleMenu;
import com.wzc.shopproduct_wzc.entity.po.ShopUserRole;
import com.wzc.shopproduct_wzc.entity.vo.RoleParams;
import com.wzc.shopproduct_wzc.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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

    @Override
    public void addRoleMenuData(Integer rid, String mids) {
        roleDao.deleteRoleMenu(rid);
         String[] split = mids.split(",");
        List<RoleMenu> list = new ArrayList<>();
        for (int i = 0; i <split.length ; i++) {
            RoleMenu rm = new RoleMenu();
            rm.setRid(rid);
            rm.setMid(Integer.parseInt(split[i]));
            list.add(rm);
        }
        roleDao.addRoleMenuData(list);
    }


    @Override
    public List<RoleMenu> queryRoleMenuByRid(Integer rid) {
        return roleDao.queryRoleMenuByRid(rid);
    }
}
