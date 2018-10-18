package com.tw.codeavengers.tradeawayapi.web.registration;

import com.tw.codeavengers.tradeawayapi.model.User;
import com.tw.codeavengers.tradeawayapi.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @CrossOrigin(origins = "*://*/*")
    @PostMapping
    public User perform(@RequestBody @Valid RegistrationRequest registrationRequest) {
        return registrationService.register(registrationRequest.mapToUser());
    }
}
