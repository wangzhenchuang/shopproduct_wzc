package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.Role;
import com.wzc.shopproduct_wzc.entity.po.RoleMenu;
import com.wzc.shopproduct_wzc.entity.vo.RoleParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RoleDao {

   public  Long  queryRoleByCount(RoleParams params);

    public List<Role> queryRoleDataPage(RoleParams params);

    @Insert("insert into shop_role (name,isDel,createDate,updateDate,author) value (#{name},#{isDel},#{createDate},#{updateDate},#{author})")
    public  void addRoleData(Role role);

    @Update("update shop_role set name=#{name},updateDate=#{updateDate},author=#{author} where id=#{id}")
    public void  updateRoleData(Role role);


    @Update("update shop_role set isDel=1 where id=#{id}")
    public  void deleteRoleData(Integer id);


    //新增角色赋权限
    void addRoleMenuData(List<RoleMenu> roleMenus);

    //删除角色拥有的权限
    void  deleteRoleMenu(Integer rid);

    //查询角色拥有的权限
    List<RoleMenu> queryRoleMenuByRid(Integer rid);

}
