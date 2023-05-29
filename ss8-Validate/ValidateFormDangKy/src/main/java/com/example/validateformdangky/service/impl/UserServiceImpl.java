package com.example.validateformdangky.service.impl;

import com.example.validateformdangky.model.User;
import com.example.validateformdangky.repository.IUserRepository;
import com.example.validateformdangky.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }
}
