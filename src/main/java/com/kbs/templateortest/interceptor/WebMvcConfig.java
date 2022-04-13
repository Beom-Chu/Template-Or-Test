package com.kbs.templateortest.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/interceptor/*")  // 인터셉터 대상 패턴
                .excludePathPatterns("/interceptor/excludePath");    // 인터셉터 제외 패턴
    }
}
