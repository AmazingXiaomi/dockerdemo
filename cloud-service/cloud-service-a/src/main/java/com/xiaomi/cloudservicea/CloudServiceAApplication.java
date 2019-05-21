package com.xiaomi.cloudservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run( CloudServiceAApplication.class, args );
    }

}
