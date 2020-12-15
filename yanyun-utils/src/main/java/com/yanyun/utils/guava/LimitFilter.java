package com.yanyun.utils.guava;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/15/20:01
 * @description
 */
@Component
public class LimitFilter implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //每秒只能接收100个请求
        registry.addInterceptor(new LimitInterceptor(100, LimitInterceptor.LimitType.DROP))
                .addPathPatterns("/**")
                //忽略拦截
                .excludePathPatterns("/login");

    }
}