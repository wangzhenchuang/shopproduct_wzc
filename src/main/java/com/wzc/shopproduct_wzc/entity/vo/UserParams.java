package com.wzc.shopproduct_wzc.entity.vo;

public class UserParams<T> {

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
