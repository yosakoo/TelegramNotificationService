package com.example.TelegramNotificationService.service;

import com.example.TelegramNotificationService.model.Company;
import com.example.TelegramNotificationService.model.Subscription;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> findByCompanyId(Company id);
}
