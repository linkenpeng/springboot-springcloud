package com.intecsec.mall.user.api;

import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.user.dto.UserDTO;
import com.intecsec.mall.user.entity.User;
import com.intecsec.mall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 10:20
 **/
@RestController
@RequestMapping("/user")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return DOUtils.copy(user, UserDTO.class);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserDTO> getUserList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        int offset = (page - 1) * pageSize;
        List<User> userList = userMapper.getList(offset, pageSize);
        return DOUtils.copyList(userList, UserDTO.class);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public int update(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        User user = DOUtils.copy(userDTO, User.class);
        return userMapper.updateByPrimaryKey(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }
}
