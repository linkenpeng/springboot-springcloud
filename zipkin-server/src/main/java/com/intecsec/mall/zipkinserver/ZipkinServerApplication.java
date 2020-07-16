package com.intecsec.mall.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @description:
 *
 * 不建议自己打包启动zipkin-server
 * 采用docker, 或者jar包启动比较好，具体见官网：
 * https://zipkin.io/pages/quickstart.html
 *
 * @author: peter.peng
 * @create: 2020-05-25 17:04
 **/
@SpringBootApplication
public class ZipkinServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }
}
