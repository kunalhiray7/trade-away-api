package com.tw.codeavengers.tradeawayapi.web.category;

import com.tw.codeavengers.tradeawayapi.model.Category;
import com.tw.codeavengers.tradeawayapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public CategoryResponse getAllCategories() {
        List<Category> allCategories = categoryService.getAllCategories();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategories(allCategories);
        return categoryResponse;
    }
}
