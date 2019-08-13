package com.xiaomi.cloudservicea.config;

import com.taobao.diamond.manager.DiamondManager;
import com.taobao.diamond.manager.ManagerListener;
import com.taobao.diamond.manager.impl.DefaultDiamondManager;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * @ClassName: DiamondConfig
 * @author: xiaomi
 * @Description: //TODO
 * @Time: 2019/8/13 0013 上午 11:35
 * @email: a1205938863@gmail.com
 */
@Component
public class DiamondConfig {
    DiamondManager manager = new DefaultDiamondManager("xiaomi", new ManagerListener() {
        @Override
        public Executor getExecutor() {
            return null;
        }

        @Override
        public void receiveConfigInfo(String configInfo) {
            System.out.println("receive config: " + configInfo);
        }
    });
}
