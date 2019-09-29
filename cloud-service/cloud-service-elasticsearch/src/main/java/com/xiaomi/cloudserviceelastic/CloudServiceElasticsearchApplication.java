package com.xiaomi.cloudserviceelastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiaomi
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.xiaomi.cloudserviceelastic"})

public class CloudServiceElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run( CloudServiceElasticsearchApplication.class, args );
    }

}
