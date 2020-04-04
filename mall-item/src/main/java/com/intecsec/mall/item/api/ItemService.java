package com.intecsec.mall.item.api;

import com.intecsec.mall.item.ItemDTO;
import com.intecsec.mall.item.manager.ItemManager;
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
    private ItemManager itemManager;

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public ItemDTO itemDetail(@PathVariable Long itemId) {
        return itemManager.itemDetail(itemId);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<ItemDTO> itemList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        return itemManager.itemList(page, pageSize);
    }
}
