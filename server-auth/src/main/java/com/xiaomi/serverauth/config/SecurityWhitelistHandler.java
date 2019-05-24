package com.xiaomi.serverauth.config;

import com.alibaba.fastjson.JSONObject;
import com.xiaomi.serverauth.utils.UrlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: SecurityWhitelistHandler
 * @User: xiaomi
 * @Description: //TODO
 * @Time: 2019/5/24 0024 下午 2:33
 * @email: a1205938863@gmail.com
 */
@Component
@Configuration
public class SecurityWhitelistHandler {
    private static Logger log = LoggerFactory.getLogger(SecurityWhitelistHandler.class);

    @Autowired
    private UrlConfig urlConfig;


    public HttpSecurity handle(HttpSecurity http) throws Exception {
        List<String> whitelist = urlConfig.getWhitelist();
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ JSONObject.toJSONString( whitelist ));
        String[] liString = new String[whitelist.size()];
        whitelist.toArray(liString);
        return http
                .authorizeRequests()
                .regexMatchers(liString)
                .permitAll()
                .and();
    }
}
