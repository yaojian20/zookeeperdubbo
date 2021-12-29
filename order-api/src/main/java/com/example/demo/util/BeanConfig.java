package com.example.demo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yaojian on 2021/12/29 16:15
 *
 * @author
 */

@Configuration
public class BeanConfig {

    @Bean
    public SnowflakeIdWorker snowflakeIdWorker() {
        System.out.println("============================================正在初始化雪花算法========================================================");
        return new SnowflakeIdWorker(0, 0);
    }

}
