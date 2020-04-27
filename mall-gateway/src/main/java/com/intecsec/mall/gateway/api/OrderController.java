package com.intecsec.mall.gateway.api;

import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.common.utils.RestResponse;
import com.intecsec.mall.gateway.service.OrderService;
import com.intecsec.mall.gateway.service.UserService;
import com.intecsec.mall.order.AddOrderDTO;
import com.intecsec.mall.order.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 10:32
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/add")
    public Object addOrder(@RequestBody @Valid AddOrderDTO addOrderDTO) {
        log.info("addOrderDTO:{}", JsonUtils.toJson(addOrderDTO));

        OrderDTO orderDTO = orderService.addOrder(addOrderDTO);

        return RestResponse.success(orderDTO);
    }

}