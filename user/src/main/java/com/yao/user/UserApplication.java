package com.yao.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDubbo
//设置jpa repository扫描包，不需要@repository注解
@EnableJpaRepositories(basePackages = "com.yao.user.repository")
@EntityScan(basePackages = "com.yao.common.entity")
//没有此注解的话该jar包中的@component@configuration都不会生效
@ComponentScan(basePackages = {"com.yao.common","com.yao.user"})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
