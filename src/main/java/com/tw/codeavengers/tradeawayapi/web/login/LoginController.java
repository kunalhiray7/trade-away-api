package com.tw.codeavengers.tradeawayapi.web.login;

import com.tw.codeavengers.tradeawayapi.security.Token;
import com.tw.codeavengers.tradeawayapi.security.TokenUtils;
import com.tw.codeavengers.tradeawayapi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping
    public LoginResponse perform(@RequestBody LoginRequest loginRequest) {
        Token token = loginService.login(loginRequest.getUsername(), loginRequest.getPassword());

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setName(token.getName());
        loginResponse.setUserName(token.getUserName());
        loginResponse.setRole(token.getRoles());
        loginResponse.setToken(tokenUtils.createToken(token));

        return loginResponse;
    }
}
