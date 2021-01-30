package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.QuanXian;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.QuanXianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/quanXian")
@CrossOrigin
public class QuanXianController {

        @Autowired
        private QuanXianService quanXianService;

         /*
     * 查询权限数据的接口文档
     * 路径  http://localhost:8080/api/quanXian/list
     *
     * 请求方式  get
     *
     * 参数
     *
     * 返回值 回值    {code:"",message:"",data:}
     * */
         @GetMapping("list")
        public ResultData  queryQuanXianData(){
            List<QuanXian> quanXianList = quanXianService.queryQuanXianData();
            return  ResultData.success(quanXianList);
        }

         /*
     * 新增权限数据的接口文档
     * 路径  http://localhost:8080/api/quanXian/add
     *
     * 请求方式  post
     *
     * 参数
     *
     * 返回值 回值    {code:"",message:"",data:null}
     * */
        @PostMapping("add")
       public  ResultData addQuanXianData(QuanXian quanXian){
             quanXianService.addQuanXianData(quanXian);
            return  ResultData.success(null);
       }


}
