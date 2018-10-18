package com.tw.codeavengers.tradeawayapi.web.category;

import com.tw.codeavengers.tradeawayapi.model.Category;

import java.util.List;

public class CategoryResponse {
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    private List<Category> categories;
}
