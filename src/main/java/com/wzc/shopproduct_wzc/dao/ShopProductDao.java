package com.wzc.shopproduct_wzc.dao;

import com.wzc.shopproduct_wzc.entity.po.ShopProduct;
import com.wzc.shopproduct_wzc.entity.vo.ProductParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShopProductDao {

        @Insert("insert  into shop_product  (name,title,bandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,updateDate,author,isDel) " +
                "value(#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{updateDate},#{author},#{isDel})")
         @Options(useGeneratedKeys = true, keyProperty = "id")
       public void add(ShopProduct product);

        //总条数
        public  Long  queryProductByCount(ProductParams params);
        //查询商品分页数据
        public List<ShopProduct> queryProductPage(ProductParams params);

        //修改商品数据
        public void   updateProductData(ShopProduct product);


        //删除商品基本数据
        @Update("update shop_product set isDel=1 where id=#{id}")
        public  Integer deleteProduct(Integer id);

}
