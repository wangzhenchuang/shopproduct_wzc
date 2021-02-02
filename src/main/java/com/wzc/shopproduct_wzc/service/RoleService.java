package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.Role;

import java.util.List;

public interface RoleService {


    public List<Role> queryRoleData();

    public  void addRoleData(Role role);

}
