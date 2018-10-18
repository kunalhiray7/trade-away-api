package com.tw.codeavengers.tradeawayapi.web.item;

import com.tw.codeavengers.tradeawayapi.model.Category;
import com.tw.codeavengers.tradeawayapi.model.Item;
import com.tw.codeavengers.tradeawayapi.model.User;
import com.tw.codeavengers.tradeawayapi.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URL;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
    }

    @Test
    public void shouldFindItemsByCategoryNameAndReturnAsJSON() throws Exception {
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
        item.setImageUrl(new URL("http://url"));

        List<ItemResponse> expectedItems = Collections.singletonList(ItemResponseMapper.map(item));

        when(itemService.findItemsByCategory(categoryName)).thenReturn(expectedItems);

        mockMvc.perform(get("/category/" + categoryName + "/items"))
                .andExpect(status().isOk())
                .andDo(mvcResult -> System.out.println(mvcResult.getResponse().getContentAsString()))
                .andExpect(jsonPath("$[0].itemName").value("Item1"));
    }

}