package com.example.TelegramNotificationService.service;


import com.example.TelegramNotificationService.model.Company;
import com.example.TelegramNotificationService.model.Subscription;
import com.example.TelegramNotificationService.repositories.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    @Autowired
    private final SubscriptionRepository subscriptionRepository;


    public List<Subscription> findByCompanyTag(Company tag){
        return subscriptionRepository.findByCompanyId(tag);
    }
}
