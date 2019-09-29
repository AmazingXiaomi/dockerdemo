package com.xiaomi.cloudserviceelastic.controller;

import com.xiaomi.cloudserviceelastic.service.ElasticsearchService;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author xiaomi
 * @ClassName: IndexController
 * @User: xiaomi
 * @Description: //TODO
 * @Time: 2019/5/22 0022 下午 5:03
 * @email: a1205938863@gmail.com
 */
@RestController
@RequestMapping("/test")
public class ElasticsearchController {
    @Autowired
    private ElasticsearchService elasticsearchService;

    @RequestMapping("/search")
    public String index () throws IOException {
        String message = elasticsearchService.searchByIndex( "messages-2019.09.23" );
        return message;
//        throw new IOException(  );
//        return "hello , this is demo api b and activeInfo is: " + "cloud-service-a";
    }
}
