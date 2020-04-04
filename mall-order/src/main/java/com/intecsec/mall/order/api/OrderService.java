package com.intecsec.mall.order.api;

import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.order.OrderDTO;
import com.intecsec.mall.order.OrderItemDTO;
import com.intecsec.mall.order.entity.Order;
import com.intecsec.mall.order.entity.OrderItem;
import com.intecsec.mall.order.mapper.OrderItemMapper;
import com.intecsec.mall.order.mapper.OrderMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 20:18
 **/
@RestController
@RequestMapping("/order")
public class OrderService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private OrderDTO detail(@PathVariable Long id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        OrderDTO orderDTO = DOUtils.copy(order, OrderDTO.class);

        decOneOrderItems(orderDTO);

        return orderDTO;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<OrderDTO> list(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        int offset = getOffset(page, pageSize);
        List<Order> orderList = orderMapper.getList(offset, pageSize);
        return DOUtils.copyList(orderList, OrderDTO.class);
    }

    @RequestMapping(value = "/{id}/{userId}", method = RequestMethod.GET)
    private OrderDTO userOrderDetail(@PathVariable Long id, @PathVariable Long userId) {
        Order order = orderMapper.getUserOrder(id, userId);
        OrderDTO orderDTO = DOUtils.copy(order, OrderDTO.class);
        decOneOrderItems(orderDTO);
        return orderDTO;
    }

    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    private List<OrderDTO> userOrderList(@PathVariable Long userId, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        int offset = getOffset(page, pageSize);
        List<Order> orderList = orderMapper.getUserOrderList(userId, offset, pageSize);
        return DOUtils.copyList(orderList, OrderDTO.class);
    }

    private int getOffset(int page, int pageSize) {
        return (page - 1) * pageSize;
    }

    private void decOneOrderItems(OrderDTO orderDTO) {
        List<OrderItem> orderItems = orderItemMapper.getListByOrderId(orderDTO.getId());
        Map<Long, List<OrderItemDTO>> orderItemMap = getOrderItemMap(orderItems);
        orderDTO.setOrderItemList(orderItemMap.get(orderDTO.getId()));
    }

    private Map<Long, List<OrderItemDTO>> getOrderItemMap(List<OrderItem> orderItems) {
        List<OrderItemDTO> orderItemDTOS = DOUtils.copyList(orderItems, OrderItemDTO.class);
        if(CollectionUtils.isEmpty(orderItems)) {
            return new HashMap<>();
        }
        Map<Long, List<OrderItemDTO>> orderItemMap = new HashMap<>();
        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            if (!orderItemMap.containsKey(orderItemDTO.getOrderId())) {
                orderItemMap.put(orderItemDTO.getOrderId(), new ArrayList<>());
            }
            orderItemMap.get(orderItemDTO.getOrderId()).add(orderItemDTO);
        }
        return  orderItemMap;
    }
}
