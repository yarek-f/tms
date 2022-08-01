package com.autoflex.tms.services;

import com.autoflex.tms.entities.User;
import com.autoflex.tms.mapers.BusinessMapper;
import com.autoflex.tms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Resource
    private BusinessMapper businessMapper;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
