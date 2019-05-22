package com.xiaomi.cloudservicea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: IndexController
 * @User: xiaomi
 * @Description: //TODO
 * @Time: 2019/5/22 0022 下午 5:03
 * @email: a1205938863@gmail.com
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping("")
    public String index () {
        return "hello , this is demo api b and activeInfo is: " + "cloud-service-a";
    }
}
