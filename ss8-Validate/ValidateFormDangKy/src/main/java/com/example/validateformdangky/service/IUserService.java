package com.example.validateformdangky.service;

import com.example.validateformdangky.model.User;

import java.util.List;

public interface IUserService {
    void save(User user);

    List<User> findByEmail(String email);

    List<User> findByPhone(String phoneNumber);
}
