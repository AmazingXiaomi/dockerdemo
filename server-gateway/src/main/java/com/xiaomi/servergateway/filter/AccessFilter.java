package com.xiaomi.servergateway.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: AccessFilter
 * @User: xiaomi
 * @Description: //TODO
 * @Time: 2019/5/22 0022 下午 4:13
 * @email: a1205938863@gmail.com
 */
public class AccessFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("this is access filter");
        return null;
    }
}
