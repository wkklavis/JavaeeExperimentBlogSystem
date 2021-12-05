package com.demo.config;

import com.demo.handler.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域配置，允许8080端口访问
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/login/test")
                .addPathPatterns("/blogs/publish")
                .addPathPatterns("/blogs/delete/*")
                .addPathPatterns("/user/delete/*")
                .addPathPatterns("/comment/delete/*")
                .addPathPatterns("/blogs/save")
                .addPathPatterns("/logout");
    }
}
