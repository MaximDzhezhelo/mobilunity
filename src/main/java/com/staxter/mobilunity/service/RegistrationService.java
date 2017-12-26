package com.staxter.mobilunity.service;

import com.staxter.mobilunity.model.RequestDto;
import com.staxter.mobilunity.model.ResponseDto;

public interface RegistrationService {

    ResponseDto handleRegistration(final RequestDto requestDto);

}
