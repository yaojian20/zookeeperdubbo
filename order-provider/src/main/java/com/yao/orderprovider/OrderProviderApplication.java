package com.yao.orderprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDubbo
@EnableJpaRepositories(basePackages = "com.yao.orderprovider.repository")
@EntityScan(basePackages = "com.example.demo.entity")
//没有此注解的话该jar包中的@component@configuration都不会生效
@ComponentScan(basePackages = {"com.example.demo","com.yao.orderprovider"})
public class OrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication.class, args);
    }

}
