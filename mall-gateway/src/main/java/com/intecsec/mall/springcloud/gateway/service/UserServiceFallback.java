package com.intecsec.mall.springcloud.gateway.service;

import com.intecsec.mall.springcloud.user.dto.UserDTO;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 10:30
 **/
@Component
public class UserServiceFallback implements UserService {

    @Override
    public UserDTO getUser(Long userId) {
        return null;
    }
}
