package com.my.blog.config;

import com.my.blog.filter.CORSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class CROSFilterConfiguration {

    @Bean
    public FilterRegistrationBean crosFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CORSFilter());
        registration.addUrlPatterns("/*");
        registration.setName("crosFilter");
        registration.setOrder(Integer.MAX_VALUE - 1);
        return registration;
    }
}
