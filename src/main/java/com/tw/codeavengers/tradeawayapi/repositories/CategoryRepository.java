package com.tw.codeavengers.tradeawayapi.repositories;

import com.tw.codeavengers.tradeawayapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}
