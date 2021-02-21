package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.XueLi;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.service.XueLiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/XueLi")
public class XueLiController {

    @Autowired
    private XueLiService xueLiService;

    @GetMapping("list")
    public ResultData  queryXueLiData(){
        List<XueLi> xueLis = xueLiService.queryXueLiData();
        return  ResultData.success(xueLis);
    }

}
