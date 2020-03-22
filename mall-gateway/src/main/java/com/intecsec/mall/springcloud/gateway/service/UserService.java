package com.intecsec.mall.springcloud.gateway.service;

import com.intecsec.mall.springcloud.user.dto.UserDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 10:28
 **/
@FeignClient(value = "USER-SERVICE", fallback = UserServiceFallback.class)
public interface UserService {

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    UserDTO getUser(@PathVariable("userId") Long userId);
}
