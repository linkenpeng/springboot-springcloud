package com.intecsec.mall.springcloud.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-21 20:24
 **/
@EnableEurekaServer
@SpringBootApplication
public class DiscoverApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DiscoverApplication.class).web(true).run(args);
    }

}
