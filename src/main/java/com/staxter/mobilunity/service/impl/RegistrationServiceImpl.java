package com.staxter.mobilunity.service.impl;

import com.staxter.mobilunity.model.RequestDto;
import com.staxter.mobilunity.model.ResponseDto;
import com.staxter.mobilunity.model.User;
import com.staxter.mobilunity.repository.UserRepository;
import com.staxter.mobilunity.service.RegistrationService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    public RegistrationServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public ResponseDto handleRegistration(final RequestDto requestDto) {

        final User apply = User.toUser(requestDto);
        final User user = userRepository.createUser(apply);

        return ResponseDto.apply(user);
    }

}
