package com.my.blog.config;


import com.my.blog.filter.JwtFilter;
import com.my.blog.util.JwtUtil;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtFilterConfiguration {

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }

    @Bean
    public FilterRegistrationBean jwtFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(jwtFilter());
        registration.addUrlPatterns("/*");
        //添加不验证token的地址.
        registration.addInitParameter("exclusions", "/logon/*,/webArticle/*,/webCategory/*,/topic/*");
        registration.setName("jwtFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }

}
