package com.xiaomi.serverauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.xiaomi.serverauth.mapper")
@ComponentScan(basePackages = {"com.xiaomi.serverauth"})
public class ServerAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServerAuthApplication.class, args );
    }



}
