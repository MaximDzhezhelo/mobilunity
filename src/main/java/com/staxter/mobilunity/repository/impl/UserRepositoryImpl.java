package com.staxter.mobilunity.repository.impl;

import com.staxter.mobilunity.exception.UserAlreadyExistsException;
import com.staxter.mobilunity.model.User;
import com.staxter.mobilunity.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Predicate;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final CopyOnWriteArraySet<User> userRepository;

    public UserRepositoryImpl() {
        this.userRepository = new CopyOnWriteArraySet<>();
    }

    @Override
    public User createUser(User user) throws UserAlreadyExistsException {

        if (isExist(user)) throw new UserAlreadyExistsException();

        final User completeUser = addParam(user);
        userRepository.add(completeUser);

        return completeUser;
    }

    private boolean isExist(final User user) {
        final Predicate<User> predicate = (s) -> (Objects.equals(s.getFirstName(), user.getFirstName()) &&
                Objects.equals(s.getUserName(), user.getUserName()) &&
                Objects.equals(s.getLastName(), user.getLastName()) &&
                Objects.equals(s.getPlainTextPassword(), user.getPlainTextPassword())
        );

        return userRepository.stream()
                .anyMatch(predicate);
    }

    private User addParam(final User user) {
        user.setId(UUID.randomUUID().toString());
        user.setHashedPassword("");
        return user;
    }

}
