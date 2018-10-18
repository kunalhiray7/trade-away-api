package com.tw.codeavengers.tradeawayapi.service;

import com.tw.codeavengers.tradeawayapi.security.Token;

public interface LoginService {
    public Token login(String username, String password);
}
