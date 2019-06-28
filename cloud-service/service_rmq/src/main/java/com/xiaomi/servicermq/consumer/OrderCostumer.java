package com.xiaomi.servicermq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: OrderCostumer
 * @author: xiaomi
 * @Description: //TODO
 * @Time: 2019/6/28 0028 下午 3:14
 * @email: a1205938863@gmail.com
 */
@Component
public class OrderCostumer implements CommandLineRunner {
    /**
     * 消费者
     */
    @Value("${apache.rocketmq.consumer.pushConsumer}")
    private String pushConsumer;

    /**
     * NameServer 地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @Override
    public void run(String... strings) throws Exception {
        this.messageListener();
    }

    private void messageListener() {
        DefaultMQPushConsumer consumer=new DefaultMQPushConsumer("OrderRocketMqGroup");

        consumer.setNamesrvAddr(namesrvAddr);
        try {
            // 程序第一次启动从消息队列头获取数据
            consumer.setConsumeFromWhere( ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET );
            // 订阅PushTopic下Tag为push的消息,都订阅消息
            consumer.subscribe("PushTopic", "TagA || TagC || TagD");

            //可以修改每次消费消息的数量，默认设置是每次消费一条
            consumer.setConsumeMessageBatchMaxSize(1);

            consumer.registerMessageListener(new MessageListenerOrderly() {

                Random random = new Random();

                @Override
                public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                    context.setAutoCommit(true);
                    System.out.print(Thread.currentThread().getName() + " Receive New Messages: " );
                    for (MessageExt msg: msgs) {
                        System.out.println(msg + ", content:" + new String(msg.getBody()));
                    }
                    try {
                        //模拟业务逻辑处理中...
                        TimeUnit.SECONDS.sleep(random.nextInt(10));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return ConsumeOrderlyStatus.SUCCESS;
                }
            });
            consumer.start();

            System.out.println("Consumer Started.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
