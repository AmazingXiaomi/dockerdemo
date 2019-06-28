package com.xiaomi.servicermq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceRmqApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServiceRmqApplication.class, args );
    }

}
