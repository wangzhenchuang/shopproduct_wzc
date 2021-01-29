package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/dept")
@CrossOrigin
public class DeptController {

    @Autowired
    private DeptService deptService;


    /*
    * 查询部门的接口文档
    * 路径  http://localhost:8080/api/dept/deptList
    *
    * 请求方式  get
    *
    * 参数
    *
    * 返回值 回值    {code:"",message:"",data:}
    * */
    @GetMapping("deptList")
    public ResultData  queryDeptData(){
        return ResultData.success(deptService.queryDeptData());
    }

}
