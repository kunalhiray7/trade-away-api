package com.tw.codeavengers.tradeawayapi.security;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenUtilsTest {


    private TokenUtils tokenUtils;

    @Before
    public void setup() {
        tokenUtils = new TokenUtils("secret");
    }

    @Test
    public void shouldCreateTokenString() {

        Token token = new Token();
        token.setUserName("username");
        token.setName("Name");
        token.setRoles("Buyer");

        String tokenString = tokenUtils.createToken(token);

        assertEquals(token, tokenUtils.parse(tokenString));
    }

}