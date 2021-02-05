package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.QuanXianDao;
import com.wzc.shopproduct_wzc.entity.po.QuanXian;
import com.wzc.shopproduct_wzc.service.QuanXianService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class QuanXianServiceImpl implements QuanXianService {


    @Resource
     private QuanXianDao quanXianDao;

    @Override
    public List<QuanXian> queryQuanXianData() {
        return quanXianDao.queryQuanXianData();
    }

    @Override
    public void addQuanXianData(QuanXian quanXian) {
        quanXian.setCreateDate(new Date());
        quanXian.setUpdateDate(new Date());
        quanXianDao.addQuanXianData(quanXian);
    }

    @Override
    public void updateQuanXianData(QuanXian quanXian) {
        quanXian.setUpdateDate(new Date());
        quanXianDao.updateQuanXianData(quanXian);
    }

    @Override
    public Integer deleteQuanXianData(Integer id) {
         return quanXianDao.deleteQuanXianData(id);
    }

    @Override
    public QuanXian queryMenuDataById(Integer id) {
        return quanXianDao.queryMenuDataById(id);
    }
}
