package com.xiaomi.servicermq.controller;

import com.xiaomi.servicermq.order.OrderDemo;
import com.xiaomi.servicermq.producer.Producer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xiaour
 * @Description: 这里是为了测试
 * @Date: 2018/8/9 15:16
 */
@RestController
public class TestController {
    @Autowired
    private Producer producer;

    @RequestMapping("/push")
    public String pushMsg(String msg) {
        try {
            return producer.send( "PushTopic", "push", msg );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    @GetMapping(value = "pushOrder")
    public void push() {
        List<OrderDemo> orderList = new ArrayList<OrderDemo>();

        OrderDemo orderDemo = new OrderDemo();
        orderDemo.setOrderId( 15103111039L );
        orderDemo.setDesc( "创建" );
        orderList.add( orderDemo );

        orderDemo = new OrderDemo();
        orderDemo.setOrderId( 15103111065L );
        orderDemo.setDesc( "创建" );
        orderList.add( orderDemo );

        orderDemo = new OrderDemo();
        orderDemo.setOrderId( 15103111039L );
        orderDemo.setDesc( "付款" );
        orderList.add( orderDemo );

        orderDemo = new OrderDemo();
        orderDemo.setOrderId( 15103117235L );
        orderDemo.setDesc( "创建" );
        orderList.add( orderDemo );

        orderDemo = new OrderDemo();
        orderDemo.setOrderId( 15103111065L );
        orderDemo.setDesc( "付款" );
        orderList.add( orderDemo );

        orderDemo = new OrderDemo();
        orderDemo.setOrderId( 15103117235L );
        orderDemo.setDesc( "付款" );
        orderList.add( orderDemo );

        orderDemo = new OrderDemo();
        orderDemo.setOrderId( 15103111065L );
        orderDemo.setDesc( "完成" );
        orderList.add( orderDemo );

        orderDemo = new OrderDemo();
        orderDemo.setOrderId( 15103111039L );
        orderDemo.setDesc( "推送" );
        orderList.add( orderDemo );

        orderDemo = new OrderDemo();
        orderDemo.setOrderId( 15103117235L );
        orderDemo.setDesc( "完成" );
        orderList.add( orderDemo );

        orderDemo = new OrderDemo();
        orderDemo.setOrderId( 15103111039L );
        orderDemo.setDesc( "完成" );
        orderList.add( orderDemo );
        String[] tags = new String[] { "TagA", "TagC", "TagD" };
        try {
            producer.orderSend( "PushTopic", tags, orderList );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
