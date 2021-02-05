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

     /*
     * 修改权限数据的接口文档
     * 路径  http://localhost:8080/api/quanXian/update
     *
     * 请求方式  post
     *
     * 参数
     *
     * 返回值 回值    {code:"",message:"",data:null}
     * */
        @PostMapping("update")
       public  ResultData updateQuanXianData(QuanXian quanXian){
             quanXianService.updateQuanXianData(quanXian);
            return  ResultData.success(null);
       }

      /*
     *  删除权限数据的接口文档
     * 路径  http://localhost:8080/api/quanXian/delete
     *
     * 请求方式  post
     *
     * 参数
     *
     * 返回值 回值    {code:"",message:"",data:null}
     * */
        @PostMapping("delete")
       public  ResultData deleteQuanXianData(Integer id){
             quanXianService.deleteQuanXianData(id);
            return  ResultData.success(null);
       }

        /*
     *  根据id查询权限数据的接口文档
     * 路径  http://localhost:8080/api/quanXian/queryMenuDataById
     *
     * 请求方式  post
     *
     * 参数
     *
     * 返回值 回值    {code:"",message:"",data:null}
     * */
       @PostMapping("queryMenuDataById")
       public  ResultData  queryMenuDataById(Integer id){
           QuanXian data = quanXianService.queryMenuDataById(id);
           return  ResultData.success(data);
       }


}
