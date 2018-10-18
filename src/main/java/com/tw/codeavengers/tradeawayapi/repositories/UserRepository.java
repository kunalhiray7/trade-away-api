package com.tw.codeavengers.tradeawayapi.repositories;


import com.tw.codeavengers.tradeawayapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
