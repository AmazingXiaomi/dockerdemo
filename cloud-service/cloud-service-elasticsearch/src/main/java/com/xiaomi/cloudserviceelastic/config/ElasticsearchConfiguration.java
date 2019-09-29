package com.xiaomi.cloudserviceelastic.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 类名：RedisCacheConfiguration<br>
 * 描述：<br>
 * 创建人：<br>
 * 创建时间：2016/9/6 17:33<br>
 *
 * @author xiaomi
 * @version v1.0
 */

@Configuration
@EnableCaching
public class ElasticsearchConfiguration extends CachingConfigurerSupport {
    Logger logger = LoggerFactory.getLogger(ElasticsearchConfiguration.class);

    @Bean
    public TransportClient redisPoolFactory() {
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
        TransportClient client = null;
        try {
            client = new PreBuiltTransportClient(settings).addTransportAddress(new TransportAddress( InetAddress.getByName("47.89.17.7"),9300)).addTransportAddress(new TransportAddress(InetAddress.getByName("39.107.33.198"),9300));
        } catch (UnknownHostException e) {
            logger.info( e.getMessage() );
        }
        return client;
    }

}
