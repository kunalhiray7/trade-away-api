package com.tw.codeavengers.tradeawayapi.service;

import com.tw.codeavengers.tradeawayapi.model.Category;
import com.tw.codeavengers.tradeawayapi.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    CategoryService categoryService = new CategoryServiceImpl();

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(categoryService);
    }

    @Test
    public void shouldReturnCategoriesList(){
        Category category = new Category();
        category.setCategoryName("category");
        List<Category> categories = Collections.singletonList(category);

        Mockito.when(categoryRepository.findAll()).thenReturn(categories);

        List<Category> allCategories = categoryService.getAllCategories();

        assertEquals(1, allCategories.size());
    }

    @Test
    public void shouldReturnNullIfNoRecordsFound(){
        Mockito.when(categoryRepository.findAll()).thenReturn(null);

        List<Category> allCategories = categoryService.getAllCategories();

        assertNull(allCategories);

    }
}