package com.intecsec.mall.gateway.api;

import com.intecsec.mall.common.utils.RestResponse;
import com.intecsec.mall.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 10:32
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserName(@PathVariable Long userId) {
        return RestResponse.success(userService.getUser(userId));
        // UserDTO userDTO = restTemplate.getForEntity("http://user-service/user/{userId}", UserDTO.class, userId).getBody();
        // return RestResponse.success(userDTO);
    }

}