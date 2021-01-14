package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.ShopType;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.ShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/type")
public class ShopTypeController {

    @Autowired
    private ShopTypeService shopTypeService;


    /*
    *
    *    查询所有的分类数据
        路径   http://localhost:8080/api/type/getData

        get请求

        参数

        返回值   {"code":200,"message":"提示",data:[{*}]}
    * */

        @GetMapping("getData")
        public ResultData  queryShopTypeList(){
            List<ShopType> shopTypes = shopTypeService.queryShopTypeList();
            return  ResultData.success(shopTypes);
        }

      /*
         查询指定pid的数据

         路径   http://localhost:8080/api/type/getDataByPid

        get请求

        参数    Pid(必填)

        返回值   {"code":200,"message":"提示",data:[{*}]}
      * */
        @GetMapping("getDataByPid")
      public  ResultData  queryShopTypeByPid(Integer pid){
            if (pid==null){
                ResultData.error(400,"参数不符合规则");
            }
          ShopType typeByPid = shopTypeService.queryShopTypeByPid(pid);
          return  ResultData.success(typeByPid);
      }

      /*
      * 新增分类

        路径   http://localhost:8080/api/type/add

       post请求

       参数    pid    name

        返回值    {code:"",message:"",data:新增的id}
      * */

      @PostMapping("add")
      public  ResultData addShopTypeData(ShopType shopType){
            shopTypeService.addShopTypeData(shopType);
            if (shopType.getPid()==null){
                ResultData.error(400,"参数不符合规则");
            }
            if (shopType.getName()==null){
                ResultData.error(400,"参数不符合规则");
            }
            //新增返回的数据
          Integer id = shopType.getId();
          return  ResultData.success(id);
      }

      /*
      * 修改

      路径   http://localhost:8080/api/type/update

       post请求

      参数   id （必传）     pid   name  isDel

     返回值     {code:"",message:""}
      * */
        @PostMapping("update")
      public  ResultData updateShopTypeData(ShopType shopType){
           if (shopType.getId()==null){
               ResultData.error(400,"参数不符合规则");
           }
          shopTypeService.updateShopTypeData(shopType);
          return ResultData.success(null);
      }

        /*
      * 删除

      路径   http://localhost:8080/api/type/delete

       post请求

      参数   id （必传）

     返回值     {code:"",message:""}
      * */
        //删除
      @PostMapping("delete")
      public  ResultData deleteShopData(Integer id){
            shopTypeService.deleteShopData(id);
            return  ResultData.success(null);
      }

}
