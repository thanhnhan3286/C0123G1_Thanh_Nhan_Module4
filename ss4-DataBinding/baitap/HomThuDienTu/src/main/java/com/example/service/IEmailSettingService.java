package com.example.service;

import com.example.model.EmailSettings;

public interface IEmailSettingService {
    EmailSettings getAll();

    void save(EmailSettings emailSettings);
}
