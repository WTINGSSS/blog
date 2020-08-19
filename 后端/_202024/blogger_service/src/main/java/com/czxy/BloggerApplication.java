package com.czxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 庭前云落
 * @Date 2020/3/3 15:18
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class BloggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BloggerApplication.class,args);
    }
}
