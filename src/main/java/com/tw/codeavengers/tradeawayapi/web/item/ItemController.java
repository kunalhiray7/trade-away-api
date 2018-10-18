package com.tw.codeavengers.tradeawayapi.web.item;

import com.tw.codeavengers.tradeawayapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{categoryName}/items")
    public List<ItemResponse> getItems(@PathVariable("categoryName") String categoryName) {
        return itemService.findItemsByCategory(categoryName);
    }
}
