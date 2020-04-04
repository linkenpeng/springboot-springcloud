package com.intecsec.mall.user.manager.impl;

import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.user.dto.UserDTO;
import com.intecsec.mall.user.entity.User;
import com.intecsec.mall.user.manager.UserManager;
import com.intecsec.mall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:36
 **/
@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUser(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return DOUtils.copy(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getUserList(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<User> userList = userMapper.getList(offset, pageSize);
        return DOUtils.copyList(userList, UserDTO.class);
    }

    @Override
    public int update(Long userId, UserDTO userDTO) {
        User user = DOUtils.copy(userDTO, User.class);
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int delete(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }
}
