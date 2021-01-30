package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.QuanXian;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.QuanXianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
