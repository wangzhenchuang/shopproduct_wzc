package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.QuanXianDao;
import com.wzc.shopproduct_wzc.entity.po.QuanXian;
import com.wzc.shopproduct_wzc.service.QuanXianService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class QuanXianServiceImpl implements QuanXianService {


    @Resource
     private QuanXianDao quanXianDao;

    @Override
    public List<QuanXian> queryQuanXianData() {
        return quanXianDao.queryQuanXianData();
    }
}
