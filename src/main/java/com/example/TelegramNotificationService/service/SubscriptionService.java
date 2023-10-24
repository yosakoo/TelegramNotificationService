package com.example.TelegramNotificationService.service;


import com.example.TelegramNotificationService.model.Company;
import com.example.TelegramNotificationService.model.Subscription;
import com.example.TelegramNotificationService.repositories.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public List<Subscription> findByCompanyId(Company id) {
        return subscriptionRepository.findByCompanyId(id);
    }
}
