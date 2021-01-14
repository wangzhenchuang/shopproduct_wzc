package com.wzc.shopproduct_wzc.entity.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BrandParams<T> {

    private  Integer start;

    private  Integer  size;

    private  String name;


    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
