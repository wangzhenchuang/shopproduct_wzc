package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.Role;
import com.wzc.shopproduct_wzc.entity.po.RoleMenu;
import com.wzc.shopproduct_wzc.entity.vo.RoleParams;

import java.util.List;
import java.util.Map;

public interface RoleService {


    public Map queryRoleDataPage(RoleParams params);

    public  void addRoleData(Role role);

    public  void updateRoleData(Role role);

    public  void  deleteRoleData(Integer id);

    public  void  addRoleMenuData(Integer rid , String mids);

    List<RoleMenu> queryRoleMenuByRid(Integer rid);

}
