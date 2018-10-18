package com.tw.codeavengers.tradeawayapi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {

    private final String secret;

    public TokenUtils(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    public String createToken(Token token) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", token.getUserName());
        claims.put("name", token.getName());
        claims.put("roles", token.getRoles());

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Token parse(String tokenString) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(tokenString).getBody();
        Token token = new Token();

        token.setUserName(claims.getSubject());
        token.setName((String) claims.get("name"));
        token.setRoles((String) claims.get("roles"));
        return token;
    }
}
