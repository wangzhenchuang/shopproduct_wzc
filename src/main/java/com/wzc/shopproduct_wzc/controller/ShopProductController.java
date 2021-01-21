package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.ShopProduct;
import com.wzc.shopproduct_wzc.entity.vo.ProductParams;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.ShopProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/product")
public class ShopProductController {

    @Autowired
    private ShopProductService shopProductService;


    /*
        新增商品的接口
    *
    * 请求路径 http://localhost:8080/api/product/add
    * 请求方式 post
    *
    * 参数 attr sku (必填)
    * 返回值 {code:"",message:"",data:null}
    * */


    @PostMapping("add")
    public ResultData  addproductData(ShopProduct product,String attr,String sku){
        if (attr==null){
            return  ResultData.error(400,"spu的数据不能为空");
        }
        if (sku==null){
            return  ResultData.error(400,"sku的数据不能为空");
        }
        shopProductService.addProduictData(product,attr,sku);
        return  ResultData.success(null);
    }


    /*
    查询商品数据
    * 请求路径 请求路径 http://localhost:8080/api/product/list
    *请求方式 post
    *参数 start size(必填)
    * 返回值 {code:"",message:"",data:list}
    * */
    @PostMapping("list")
    public  ResultData  queryProductData(ProductParams params){
        if (params.getSize()==null){
            return  ResultData.error(400,"参数不符合规定");
        }
        if (params.getStart()==null){
            return  ResultData.error(400,"参数不符合规定");
        }
        Map map = shopProductService.queryProductPage(params);
        return  ResultData.success(map);
    }

     /*
        修改商品的接口
    *
    * 请求路径 http://localhost:8080/api/product/update
    * 请求方式 post
    *
    * 参数
    * 返回值 {code:"",message:"",data:null}
    * */
    @PostMapping("update")
    public  ResultData  updateProductData(ShopProduct product){
        shopProductService.updateProductData(product);
        return  ResultData.success(null);
    }

    /*
        删除商品基本数据的接口
    *
    * 请求路径 http://localhost:8080/api/product/delete
    * 请求方式 post
    *
    * 参数 id(毕传)
    * 返回值 {code:"",message:"",data:null}
    * */
    @PostMapping("delete")
    public  ResultData  deleteProduct(Integer id){
        if (id==null){
            return  ResultData.error(400,"参数不对");
        }
        shopProductService.deleteProduct(id);
        return  ResultData.success(null);
    }

}
