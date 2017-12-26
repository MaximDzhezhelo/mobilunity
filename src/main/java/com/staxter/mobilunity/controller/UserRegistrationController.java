package com.staxter.mobilunity.controller;

import com.staxter.mobilunity.model.RequestDto;
import com.staxter.mobilunity.model.ResponseDto;
import com.staxter.mobilunity.service.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistrationController {

    public static final String URL_REGISTRATION = "/userservice/register";

    private final RegistrationService registrationService;

    public UserRegistrationController(RegistrationService registrationService) { this.registrationService = registrationService; }

    @PostMapping(URL_REGISTRATION)
    public @ResponseBody ResponseDto receiver(@RequestBody RequestDto requestDto){
        return registrationService.handleRegistration(requestDto);
    }

}
