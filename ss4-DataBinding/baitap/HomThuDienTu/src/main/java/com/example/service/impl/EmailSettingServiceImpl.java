package com.example.service.impl;

import com.example.model.EmailSettings;
import com.example.repository.IEmailSettingsRepository;
import com.example.service.IEmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmailSettingServiceImpl implements IEmailSettingService {
    @Autowired
    IEmailSettingsRepository iEmailSettingsRepository;
    @Override
    public EmailSettings getAll() {
        return iEmailSettingsRepository.getAll();
    }

    @Override
    public void save(EmailSettings emailSettings) {
        iEmailSettingsRepository.save(emailSettings);
    }
}
