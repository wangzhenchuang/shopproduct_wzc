package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.ShopBrand;
import com.wzc.shopproduct_wzc.entity.vo.BrandParams;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.ShopBrandService;
import com.wzc.shopproduct_wzc.utils.SaveFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/brand")
public class ShopBrandController {


    @Autowired
    private ShopBrandService shopBrandService;


     /*
    *
    *    查询所有的品牌数据
        路径   http://localhost:8080/api/brand/getData

        post请求

        参数  start  size  (两个必填)

        返回值   {"code":200,"message":"提示",data:[{*}]}
    * */
     @PostMapping("getData")
    public ResultData  queryBrandPage(BrandParams params){

        if (params.getStart()==null){
            return  ResultData.error(400,"参数不符合规则");
        }
        if (params.getSize()==null){
            return  ResultData.error(400,"参数不符合规则");
        }
        Map map = shopBrandService.queryBrandPage(params);
        return  ResultData.success(map);
    }


      /*
      * 新增品牌数据

        路径   http://localhost:8080/api/brand/add

       post请求

       参数
       name    名称

        bandE  首字母

        imgpath   图片log

        bandDesc  品牌介绍

        ord   排序字段

        author   操作人

        返回值    {code:"",message:"",data:}
      * */

    @PostMapping("add")
    public  ResultData addBrandData(ShopBrand shopBrand){
         shopBrandService.addBrandData(shopBrand);
         return  ResultData.success(null);
    }
     /*
      * 修改品牌数据

        路径   http://localhost:8080/api/brand/update

       post请求

       参数   id(必填)

        返回值    {code:"",message:"",data:}
      * */
     @PostMapping("update")
    public  ResultData updateBrandData(ShopBrand shopBrand){
        shopBrandService.updateBrandData(shopBrand);
        return  ResultData.success(null);
    }

     /*
      * 删除品牌数据

        路径   http://localhost:8080/api/brand/delete

       post请求

       参数   id(必填)

        返回值    {code:"",message:"",data:}
      * */
    @PostMapping("delete")
    public  ResultData  deleteBrandData(Integer id){
         shopBrandService.deleteBrandData(id);
         return  ResultData.success(null);
    }

  /*   图片上传
    *请求路径 : http://localhost:8080/api/brand/upload
    *
    *请求方式 post
    *
    *返回值
     * Code(200);成功回调函数
     * Message("success");返回值
     * Data(data);数据
    *
    * 参数
    *  file  必填
    * */
    //图片上传
    @PostMapping("upload")
    public  ResultData upload(MultipartFile file, HttpServletRequest request){
        String imgs = SaveFile.saveFile(file, "imgs", request);
        return  ResultData.success(imgs);
    }

/*   回显
    *请求路径 : http://localhost:8080/api/brand/queryById
    *
    *请求方式 post
    *
    *返回值
     * Code(200);成功回调函数
     * Message("success");返回值
     * Data(data);数据
    *
    * 参数
    * id 必填
    * */
    //图片上传
    @GetMapping("queryById")
    public  ResultData  queryBrandById(Integer id){
        ShopBrand shopBrand = shopBrandService.queryBrandById(id);
        return  ResultData.success(shopBrand);
    }
}
