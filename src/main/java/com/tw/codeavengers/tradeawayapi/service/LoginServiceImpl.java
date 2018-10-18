package com.tw.codeavengers.tradeawayapi.service;

import com.tw.codeavengers.tradeawayapi.model.User;
import com.tw.codeavengers.tradeawayapi.repositories.UserRepository;
import com.tw.codeavengers.tradeawayapi.security.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Token login(String username, String password) {
        User user = userRepository.findOne(username);
        Token token = null;
        if (user != null && user.getPassword().equals(password)) {
            token = new Token();
            token.setUserName(user.getUsername());
            token.setName(user.getName());
            token.setRoles(user.getRole());
        } else {
            throw new BadCredentialsException("Wrong username or password");
        }

        return token;
    }
}
