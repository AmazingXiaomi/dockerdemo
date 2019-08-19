package com.xiaomi.cloudservicea.config;

import com.taobao.diamond.manager.DiamondManager;
import com.taobao.diamond.manager.ManagerListener;
import com.taobao.diamond.manager.impl.DefaultDiamondManager;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @ClassName: DiamondConfig
 * @author: xiaomi
 * @Description: //TODO
 * @Time: 2019/8/13 0013 上午 11:35
 * @email: a1205938863@gmail.com
 */
@Component
public class DiamondConfigCallBack {
    @Autowired
    private DiamondBean diamondBean;
    DiamondManager manager = new DefaultDiamondManager("xiaomi","xiaomi.properties", new ManagerListener() {
        @Override
        public Executor getExecutor() {
            return null;
        }

        @Override
        public void receiveConfigInfo(String configInfo) {
            try {
                System.out.println("receive config: " + configInfo);
                Properties properties=new Properties(  );
                properties.load( new ByteArrayInputStream(configInfo.getBytes()) );
                new RelaxedDataBinder( diamondBean ,"xiaomi").bind( new MutablePropertyValues(properties) );
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    });
}
