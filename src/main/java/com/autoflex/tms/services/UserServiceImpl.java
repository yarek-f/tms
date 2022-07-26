package com.autoflex.tms.services;

import com.autoflex.tms.entities.User;
import com.autoflex.tms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
