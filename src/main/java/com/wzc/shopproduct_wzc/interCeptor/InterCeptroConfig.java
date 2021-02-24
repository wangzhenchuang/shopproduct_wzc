package com.wzc.shopproduct_wzc.interCeptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterCeptroConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

         //跨域的拦截器
       InterceptorRegistration kuaYu = registry.addInterceptor(new KuaYuInterCeptros());
        kuaYu.addPathPatterns("/**");

         //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new InterCeptorController());
        //设置拦截的请求
        registration.addPathPatterns("/**");
        //设置不拦截的请求
        List<String> list =new ArrayList<>();
        list.add("/api/login/**");
        list.add("/api/dept/**");
        list.add("/api/XueLi/**");
        registration.excludePathPatterns(list);


        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new AopInterCeptro());
        interceptorRegistration.addPathPatterns("/**");

    }
}
