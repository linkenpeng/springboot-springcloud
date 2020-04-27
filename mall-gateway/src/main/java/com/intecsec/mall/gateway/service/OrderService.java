package com.intecsec.mall.gateway.service;

import com.intecsec.mall.order.AddOrderDTO;
import com.intecsec.mall.order.OrderDTO;
import com.intecsec.mall.user.dto.UserDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @description: Feign 是一个声明式的Web Service客户端， 目的是让webservice调用更简单
 * Feign 整合了 Ribbon和Hystrix
 * @author: peter.peng
 * @create: 2020-03-22 10:28
 **/
@FeignClient(value = "ORDER-SERVICE")
public interface OrderService {

    @PostMapping("/order/add")
    OrderDTO addOrder(@RequestBody AddOrderDTO addOrderDTO);
}
