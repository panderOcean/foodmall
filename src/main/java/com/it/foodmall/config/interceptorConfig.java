package com.it.foodmall.config;

import com.it.foodmall.interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class interceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
     registry.addInterceptor(new loginInterceptor())
             .addPathPatterns("/*")
             .excludePathPatterns("/user/login","/user/register","/index.html");

    }
}
