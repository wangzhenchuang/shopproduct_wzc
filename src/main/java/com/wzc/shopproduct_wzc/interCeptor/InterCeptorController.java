package com.wzc.shopproduct_wzc.interCeptor;

import com.alibaba.fastjson.JSONObject;
import com.wzc.shopproduct_wzc.entity.po.ShopUser;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.utils.JWT;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InterCeptorController implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {


        String token = request.getParameter("token");
        if (token==null){
           Map map = new HashMap();
            map.put("code", 400);
            map.put("data", " que shao token");
            // 响应请求 返回json字符串信息
            response.getWriter().write(JSONObject.toJSONString(map));
            return false;
        }

        //解密token 是否正确
        Map unsign = JWT.unsign(token, Map.class);
        if (unsign==null){
             Map map = new HashMap();
            map.put("code", 500);
            map.put("data", " token is error");
            // 响应请求 返回json字符串信息
            response.getWriter().write(JSONObject.toJSONString(map));
            return false;
        }
        return true;
    }
}
