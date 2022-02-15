package com.zhangz1.maildemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by zhangz1 on 2022/2/15 19:56
 * 允许跨域访问
 * addMapping 可限制哪个请求可以通过跨域
 * allowedHeaders 可限制固定请求头可以通过跨域
 * allowedMethods 可限制固定methods可以通过跨域
 * allowedOrigins 可限制访问ip可以通过跨域
 * allowCredentials(true) 是否允许发送cookie
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
                .allowCredentials(true)
                .allowedOrigins()
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
