package com.wzc.shopproduct_wzc.interCeptor;

import com.wzc.shopproduct_wzc.utils.RedisUtils_wzc;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AopInterCeptro implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestURI = request.getRequestURI();
        String s = RedisUtils_wzc.get(requestURI);
        if (s == null) {
            s = "0";
        }
        int i = Integer.parseInt(s);
        String set = RedisUtils_wzc.set(requestURI, i + 1);
        System.out.println("请求次数："+(i+1)+"次");
        return true;
    }
}
