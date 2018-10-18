package com.tw.codeavengers.tradeawayapi.web.item;

import com.tw.codeavengers.tradeawayapi.model.Category;
import com.tw.codeavengers.tradeawayapi.model.Item;
import com.tw.codeavengers.tradeawayapi.model.User;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ItemResponseMapperTest {

    @Test
    public void shoudlMapItems() throws MalformedURLException {
        String categoryName = "SomeCategory";
        Category category = new Category();
        category.setCategoryName(categoryName);

        User seller = new User();
        seller.setDateOfBirth(LocalDate.now());
        seller.setUsername("Seller1");
        seller.setRole("SELLER");

        Set<User> sellers = new HashSet<>();
        sellers.add(seller);

        Item item = new Item();
        item.setItemName("Item1");
        item.setDescription("Some Desc");
        item.setCategory(category);
        item.setSellers(sellers);
        item.setImageUrl(new URL("http://"));

        List<ItemResponse> itemResponses = ItemResponseMapper.map(Collections.singletonList(item));

        ItemResponse itemResponse = itemResponses.get(0);

        assertEquals(item.getItemName(), itemResponse.getItemName());
        assertEquals(item.getCategory().getCategoryName(), itemResponse.getCategory());
        assertEquals(item.getDescription(), itemResponse.getDescription());
        assertEquals(item.getImageUrl().toString(), itemResponse.getImageUrl());
        assertEquals(item.getPrice(), itemResponse.getPrice(), 0);
        assertEquals(item.getSellers().stream().map(User::getUsername).collect(Collectors.toList()), itemResponse.getSellers());
    }

}