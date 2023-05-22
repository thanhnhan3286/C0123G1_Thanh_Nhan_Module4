package com.example.repository.impl;

import com.example.model.EmailSettings;
import com.example.repository.IEmailSettingsRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailSettingRepositoryImpl implements IEmailSettingsRepository {
static EmailSettings emailSettings = new EmailSettings("Vietnamese",20,true,"Nghia");

    @Override
    public EmailSettings getAll() {
        return emailSettings;
    }

    @Override
    public void save(EmailSettings emailSetting) {
        emailSettings.setLanguage(emailSetting.getLanguage());
        emailSettings.setLanguage(String.valueOf(emailSetting.getPageSize()));
        emailSettings.setLanguage(String.valueOf(emailSetting.getSpamsFilter()));
        emailSettings.setLanguage(emailSetting.getSignature());
    }
}
