package com.example.repository;

import com.example.model.EmailSettings;

public interface IEmailSettingsRepository {
    EmailSettings getAll();

    void save(EmailSettings emailSettings);
}
