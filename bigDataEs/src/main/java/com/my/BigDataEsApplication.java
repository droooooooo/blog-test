package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.my.blog.repository.dao")
public class BigDataEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigDataEsApplication.class, args);
    }

}

