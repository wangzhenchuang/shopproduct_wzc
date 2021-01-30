package com.wzc.shopproduct_wzc.service;

import com.wzc.shopproduct_wzc.entity.po.QuanXian;

import java.util.List;

public interface QuanXianService {

    public List<QuanXian>  queryQuanXianData();

    public  void addQuanXianData(QuanXian quanXian);

    public  void  updateQuanXianData(QuanXian quanXian);

    public  Integer deleteQuanXianData(Integer id);
}
