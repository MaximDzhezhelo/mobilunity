package com.staxter.mobilunity.repository;

import com.staxter.mobilunity.exception.UserAlreadyExistsException;
import com.staxter.mobilunity.model.User;

public interface UserRepository {
    User createUser(User user ) throws UserAlreadyExistsException;
}
