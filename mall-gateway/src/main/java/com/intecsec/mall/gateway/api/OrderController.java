package com.intecsec.mall.gateway.api;

import com.intecsec.mall.common.utils.RestResponse;
import com.intecsec.mall.gateway.service.UserService;
import com.intecsec.mall.order.AddOrderDTO;
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
public class OrderController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/add")
    public Object addOrder(@RequestBody @Valid AddOrderDTO addOrderDTO) {
        return RestResponse.success(addOrderDTO);
    }

}