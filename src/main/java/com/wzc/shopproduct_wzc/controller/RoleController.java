package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.Role;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/role")
@CrossOrigin
public class RoleController {


    @Autowired
    private RoleService roleService;


    /*查询角色数据接口
    * 请求路径  http://localhost:8080/api/role/list
    *
    * 请求方式  get
    *
    * 参数
    *
    * 返回值     {code:"",message:"",data:}
    *
    * */
    @GetMapping("list")
    public ResultData  queryRoleData(){
        List<Role> roleList = roleService.queryRoleData();
        return ResultData.success(roleList);
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


}
