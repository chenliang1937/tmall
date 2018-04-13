package com.tmall;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.tmall.dao")
@EnableTransactionManagement
public class TmallApplication {

    @Bean
    PageHelper pageHelper(){
        return new PageHelper();
    }

    public static void main(String[] args) {
        SpringApplication.run(TmallApplication.class, args);
    }
}
