package com.xiaomi.servergateway.config;

import com.xiaomi.servergateway.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: GatewayConf
 * @User: xiaomi
 * @Description: //TODO
 * @Time: 2019/5/22 0022 下午 4:11
 * @email: a1205938863@gmail.com
 */
@Configuration
public class GatewayConf {
    @Bean
    public AccessFilter accessFilter(){
     return new AccessFilter();
    }
}
