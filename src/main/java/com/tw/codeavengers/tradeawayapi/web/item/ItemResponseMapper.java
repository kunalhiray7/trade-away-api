package com.tw.codeavengers.tradeawayapi.web.item;

import com.tw.codeavengers.tradeawayapi.model.Item;
import com.tw.codeavengers.tradeawayapi.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class ItemResponseMapper {

    public static ItemResponse map(Item item) {
        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setItemName(item.getItemName());
        itemResponse.setCategory(item.getCategory().getCategoryName());
        itemResponse.setDescription(item.getDescription());
        itemResponse.setImageUrl(item.getImageUrl().toString());
        itemResponse.setPrice(item.getPrice());
        itemResponse.setSellers(item.getSellers().stream().map(User::getUsername).collect(Collectors.toList()));

        return itemResponse;
    }

    public static List<ItemResponse> map(List<Item> items) {
        return items.stream().map(ItemResponseMapper::map).collect(Collectors.toList());
    }
}

