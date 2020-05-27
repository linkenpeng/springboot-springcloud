package com.intecsec.mall.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @description:
 *
 * EnableZuulProxy 包含所有 EnableZuulServer的功能
 * 同时还包括了
 * @EnableCircuitBreaker
 * @EnableDiscoveryClient
 *
 * EnableZuulServer过滤器
 * 1. pre类型
 * ServletDetectionFilter
 * FormBodyWrapperFilter
 * DebugFilter
 * PreDecorationFilter [EnableZuulProxy新增]
 *
 * 2.route类型
 * SendForwardFilter
 * RibbonRoutingFilter [EnableZuulProxy新增]
 * SimpleHostRoutingFilter [EnableZuulProxy新增]
 *
 * 3.post类型
 * SendResponseFilter
 *
 * 4.error类型
 * SendErrorFilter
 *
 * @author: peter.peng
 * @create: 2020-03-22 10:04
 **/
@SpringBootApplication
@EnableZuulProxy
public class ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

}
