package com.intecsec.mall.mapper;

import com.intecsec.mall.entity.UserConsignee;

public interface UserConsigneeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserConsignee record);

    int insertSelective(UserConsignee record);

    UserConsignee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserConsignee record);

    int updateByPrimaryKey(UserConsignee record);
}