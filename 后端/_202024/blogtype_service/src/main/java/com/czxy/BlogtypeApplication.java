package com.czxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 庭前云落
 * @Date 2020/3/4 12:47
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class BlogtypeApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogtypeApplication.class,args);
    }
}
