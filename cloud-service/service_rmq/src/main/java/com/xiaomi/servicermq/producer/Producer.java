package com.xiaomi.servicermq.producer;

import com.xiaomi.servicermq.order.OrderDemo;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: Xiaour
 * @Description:生产者
 * @Date: 2018/8/9 14:52
 */

@Component
public class Producer {

    /**
     * 生产者的组名
     */
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;

    private DefaultMQProducer producer;
    /**
     * NameServer 地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @PostConstruct
    public void defaultMQProducer() {

        //生产者的组名
        producer = new DefaultMQProducer( producerGroup );
        //指定NameServer地址，多个地址以 ; 隔开
        producer.setNamesrvAddr( namesrvAddr );
        producer.setVipChannelEnabled( false );
        try {
            producer.start();
            System.out.println( "-------->:producer启动了" );
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public String send(String topic, String tags, String body) throws InterruptedException, RemotingException, MQClientException, MQBrokerException, UnsupportedEncodingException {
        Message message = new Message( topic, tags, body.getBytes( RemotingHelper.DEFAULT_CHARSET ) );

        message.setDelayTimeLevel( 1 );
        StopWatch stop = new StopWatch();
        stop.start();
        SendResult result = producer.send( message );
        System.out.println( "发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus() );
        stop.stop();
        return "{\"MsgId\":\"" + result.getMsgId() + "\"}";
    }

    public void orderSend(String topic, String[] tags, List<OrderDemo> list) throws InterruptedException, RemotingException, MQClientException, MQBrokerException, UnsupportedEncodingException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String dateStr = sdf.format( date );
        for (int i = 0; i < list.size(); i++) {
            String body = dateStr + " Hello RocketMQ " + list.get( i );
            Message msg = new Message( topic, tags[i % tags.length], "KEY" + i, body.getBytes() );
            SendResult sendResult = null;//订单id
            try {
                sendResult = producer.send( msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Long id = (Long) arg;
                        long index = id % mqs.size();
                        return mqs.get( (int) index );
                    }
                }, list.get( i ).getOrderId() );
            } catch (MQClientException e) {
                e.printStackTrace();
            } catch (RemotingException e) {
                e.printStackTrace();
            } catch (MQBrokerException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( sendResult + ", body:" + body );
        }
    }

}
