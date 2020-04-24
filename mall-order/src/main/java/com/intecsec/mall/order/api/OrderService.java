package com.intecsec.mall.order.api;

import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.order.*;
import com.intecsec.mall.order.manager.OrderManager;
import com.intecsec.mall.order.service.UserService;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 20:18
 **/
@RestController
@RequestMapping("/order")
public class OrderService {

    @Autowired
    private OrderManager orderManager;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private OrderDTO getOrder(@PathVariable Long id) {
        return orderManager.getOrder(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<OrderDTO> getOrderList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        return orderManager.getOrderList(page, pageSize);
    }

    @RequestMapping(value = "/{id}/{userId}", method = RequestMethod.GET)
    private OrderDTO getUserOrder(@PathVariable Long id, @PathVariable Long userId) {
        return orderManager.getUserOrder(id, userId);
    }

    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    private List<OrderDTO> getUserOrderList(@PathVariable Long userId, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        return orderManager.getUserOrderList(page, pageSize, userId);
    }

    @PostMapping("/add")
    private OrderDTO addOrder(@RequestBody AddOrderDTO addOrderDTO) {

        UserConsigneeDTO userConsigneeDTO = userService.getUserConsignee(addOrderDTO.getConsignee_id());
        OrderConsigneeDTO orderConsigneeDTO = DOUtils.copy(userConsigneeDTO, OrderConsigneeDTO.class);

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(addOrderDTO.getUser_id());

        List<OrderItemDTO> itemDTOS = new ArrayList<>();
        for(AddOrderItemDTO addOrderItemDTO : addOrderDTO.getOrder_item_list()) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setItemId(addOrderItemDTO.getItem_id());
            orderItemDTO.setItemNum(addOrderItemDTO.getNumber());


            itemDTOS.add(orderItemDTO);
        }

        orderDTO.setOrderConsigneeDTO(orderConsigneeDTO);
        orderDTO.setOrderItemList(itemDTOS);

        return orderManager.addOrder(orderDTO);
    }
}