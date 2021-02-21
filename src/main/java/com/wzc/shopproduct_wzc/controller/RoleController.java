package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.Role;
import com.wzc.shopproduct_wzc.entity.po.RoleMenu;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.entity.vo.RoleParams;
import com.wzc.shopproduct_wzc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/role")
public class RoleController {


    @Autowired
    private RoleService roleService;


    /*查询角色数据接口
    * 请求路径  http://localhost:8080/api/role/list
    *
    * 请求方式  post
    *
    * 参数
    *
    * 返回值     {code:"",message:"",data:}
    *
    * */
    @PostMapping("list")
    public ResultData  queryRoleData(RoleParams params){
        Map map = roleService.queryRoleDataPage(params);
        return ResultData.success(map);
    }

    /*新增角色数据接口
    * 请求路径  http://localhost:8080/api/role/add
    *
    * 请求方式  post
    *
    * 参数
    *
    * 返回值     {code:"",message:"",data:null}
    *
    * */
    @PostMapping("add")
    public ResultData  addRoleData(Role role){
       roleService.addRoleData(role);
        return ResultData.success(null);
    }

    /*修改角色数据接口
    * 请求路径  http://localhost:8080/api/role/update
    *
    * 请求方式  post
    *
    * 参数
    *
    * 返回值     {code:"",message:"",data:null}
    *
    * */
    @PostMapping("update")
    public ResultData  updateRoleData(Role role){
       roleService.updateRoleData(role);
        return ResultData.success(null);
    }

    /*逻辑删除角色数据接口
    * 请求路径  http://localhost:8080/api/role/delete
    *
    * 请求方式  post
    *
    * 参数
    *
    * 返回值     {code:"",message:"",data:null}
    *
    * */
    @PostMapping("delete")
    public ResultData  deleteRoleData(Integer id){
        roleService.deleteRoleData(id);
        return ResultData.success(null);
    }
     /*角色赋权限接口
    * 请求路径  http://localhost:8080/api/role/addRoleMenu
    *
    * 请求方式  post
    *
    * 参数
    *
    * 返回值     {code:"",message:"",data:null}
    *
    * */
    @PostMapping("addRoleMenu")
    public  ResultData  addRoleMenuData(Integer rid,String mids){
        roleService.addRoleMenuData(rid,mids);
        return  ResultData.success(null);
    }

     /*查询角色拥有的权限接口
    * 请求路径  http://localhost:8080/api/role/queryRoleMenuByRid
    *
    * 请求方式  get
    *
    * 参数
    *
    * 返回值     {code:"",message:"",data:权限数据}
    *
    * */
    @GetMapping("queryRoleMenuByRid")
    public  ResultData  queryRoleMenuByRid(Integer rid){
        List<RoleMenu> roleMenuList = roleService.queryRoleMenuByRid(rid);
        return  ResultData.success(roleMenuList);



    }


}
