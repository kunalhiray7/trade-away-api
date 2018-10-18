package com.tw.codeavengers.tradeawayapi.service;

import com.tw.codeavengers.tradeawayapi.model.Category;
import com.tw.codeavengers.tradeawayapi.model.Item;
import com.tw.codeavengers.tradeawayapi.model.User;
import com.tw.codeavengers.tradeawayapi.repositories.ItemsRepository;
import com.tw.codeavengers.tradeawayapi.web.item.ItemResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    ItemsRepository itemsRepository;

    @InjectMocks
    ItemService itemService;

    @Test
    public void shouldFetchItemsByCategoryName() throws MalformedURLException {
        String categoryName = "SomeCategory";
        Category category = new Category();
        category.setCategoryName(categoryName);

        User seller = new User();
        seller.setDateOfBirth(LocalDate.now());
        seller.setName("Seller1");
        seller.setRole("SELLER");

        Set<User> sellers = new HashSet<>();
        sellers.add(seller);

        Item item = new Item();
        item.setItemName("Item1");
        item.setDescription("Some Desc");
        item.setCategory(category);
        item.setSellers(sellers);
        item.setImageUrl(new URL("http://"));

        List<Item> expectedItems = Collections.singletonList(item);

        when(itemsRepository.findByCategory(category)).thenReturn(expectedItems);

        List<ItemResponse> items = itemService.findItemsByCategory(categoryName);

        assertEquals(expectedItems.get(0).getItemName(), items.get(0).getItemName());
    }
}