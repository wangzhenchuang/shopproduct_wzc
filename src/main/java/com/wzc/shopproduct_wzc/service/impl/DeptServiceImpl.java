package com.wzc.shopproduct_wzc.service.impl;

import com.wzc.shopproduct_wzc.dao.DeptDao;
import com.wzc.shopproduct_wzc.entity.po.Dept;
import com.wzc.shopproduct_wzc.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDao deptDao;


    @Override
    public List<Dept> queryDeptData() {
        return deptDao.queryDeptData();
    }
}
