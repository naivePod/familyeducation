package com.lgs.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 注册拦截器

        // 拦截路径
//        loginRegistry.addPathPatterns("/**");
//        // 排除路径
//        loginRegistry.excludePathPatterns("/");
//        loginRegistry.excludePathPatterns("/login");
//        loginRegistry.excludePathPatterns("/loginout");
//        // 排除资源请求
//        loginRegistry.excludePathPatterns("/css/login/*.css");
//        loginRegistry.excludePathPatterns("/js/login/**/*.js");
//        loginRegistry.excludePathPatterns("/image/login/*.png");
    }
}
