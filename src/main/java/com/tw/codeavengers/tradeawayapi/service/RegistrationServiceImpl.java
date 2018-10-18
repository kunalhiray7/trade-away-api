package com.tw.codeavengers.tradeawayapi.service;

import com.tw.codeavengers.tradeawayapi.model.User;
import com.tw.codeavengers.tradeawayapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        if (userRepository.findOne(user.getUsername()) != null){
            throw new FieldValidationException("Username already exists", "username");
        }
        return userRepository.save(user);
    }
}
