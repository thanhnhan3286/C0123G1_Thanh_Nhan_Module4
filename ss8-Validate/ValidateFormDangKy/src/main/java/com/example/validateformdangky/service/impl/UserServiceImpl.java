package com.example.validateformdangky.service.impl;

import com.example.validateformdangky.model.User;
import com.example.validateformdangky.repository.IUserRepository;
import com.example.validateformdangky.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }

    @Override
    public List<User> findByPhone(String phoneNumber) {
        return userRepository.findAllByPhoneNumber(phoneNumber);
    }
}
