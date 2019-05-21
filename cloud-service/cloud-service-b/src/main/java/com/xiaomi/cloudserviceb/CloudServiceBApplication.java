package com.xiaomi.cloudserviceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudServiceBApplication {

    public static void main(String[] args) {
        SpringApplication.run( CloudServiceBApplication.class, args );
    }

}
