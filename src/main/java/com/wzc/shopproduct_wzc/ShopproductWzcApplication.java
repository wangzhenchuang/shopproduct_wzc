package com.wzc.shopproduct_wzc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wzc.shopproduct_wzc.dao")
public class ShopproductWzcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopproductWzcApplication.class, args);
    }

}
