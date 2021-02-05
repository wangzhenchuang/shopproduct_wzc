package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.XueLiDao;
import com.wzc.shopproduct_wzc.entity.po.XueLi;
import com.wzc.shopproduct_wzc.service.XueLiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class XueLiServiceImpl implements XueLiService {

    @Resource
    private XueLiDao xueLiDao;

    @Override
    public List<XueLi> queryXueLiData() {
        return xueLiDao.queryXueLiData();
    }
}
