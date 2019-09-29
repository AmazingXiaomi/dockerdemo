package com.xiaomi.cloudserviceelastic.service.impl;

import com.xiaomi.cloudserviceelastic.service.ElasticsearchService;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.document.DocumentField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: ElasticsearchServiceImpl
 * @author: xiaomi
 * @Description: //TODO
 * @Time: 2019/9/29 0029 下午 3:40
 * @email: a1205938863@gmail.com
 */
@Service
public class ElasticsearchServiceImpl implements ElasticsearchService {
    @Autowired
    private TransportClient client;

    @Override
    public String searchByIndex(String index) {
            // prepareGet 参数分别为index、type、id
            GetResponse response = client.prepareGet( index, "doc", "pJp9XW0BD70UMfwxXeLz" ).get();
            String id = response.getId();
             index = response.getIndex();
            Map<String, DocumentField> fields = response.getFields();
            // 返回的source，也就是数据源
            Map<String, Object> source = response.getSource();
            System.out.println( "ID:" + id + ",Index:" + index );
            Set<String> fieldKeys = fields.keySet();
            for (String s : fieldKeys) {
                DocumentField documentField = fields.get( s );
                String name = documentField.getName();
                List<Object> values = documentField.getValues();
                System.out.println( name + ":" + values.toString() );
            }
            System.out.println( "==========" );
            Set<String> sourceKeys = source.keySet();
            for (String s : sourceKeys) {
                Object o = source.get( s );
                System.out.println( s + ":" + o );
            }
            return  source.toString();
        }
    }
