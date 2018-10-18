package com.tw.codeavengers.tradeawayapi.service;

import com.tw.codeavengers.tradeawayapi.model.Category;
import com.tw.codeavengers.tradeawayapi.repositories.ItemsRepository;
import com.tw.codeavengers.tradeawayapi.web.item.ItemResponse;
import com.tw.codeavengers.tradeawayapi.web.item.ItemResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<ItemResponse> findItemsByCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);

        return ItemResponseMapper.map(itemsRepository.findByCategory(category));
    }
}
