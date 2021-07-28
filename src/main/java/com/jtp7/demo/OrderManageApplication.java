package com.jtp7.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.jtp7.demo.mapper")
public class OrderManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderManageApplication.class, args);
    }

}
