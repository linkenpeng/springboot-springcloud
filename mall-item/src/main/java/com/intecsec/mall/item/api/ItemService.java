package com.intecsec.mall.item.api;

import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.item.ItemDTO;
import com.intecsec.mall.item.entity.Item;
import com.intecsec.mall.item.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 20:17
 **/
@RestController
@RequestMapping("/item")
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    private ItemDTO itemDetail(@PathVariable Long itemId) {
        Item item = itemMapper.selectByPrimaryKey(itemId);
        return DOUtils.copy(item, ItemDTO.class);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<ItemDTO> itemList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        int offset = (page - 1) * pageSize;
        List<Item> itemList = itemMapper.getList(offset, pageSize);
        return DOUtils.copyList(itemList, ItemDTO.class);
    }
}
