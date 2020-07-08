package com.intecsec.mall.mapper;

import com.intecsec.mall.entity.OrderConsignee;

public interface OrderConsigneeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderConsignee record);

    int insertSelective(OrderConsignee record);

    OrderConsignee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderConsignee record);

    int updateByPrimaryKey(OrderConsignee record);
}