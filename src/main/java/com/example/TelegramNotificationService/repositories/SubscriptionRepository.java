package com.example.TelegramNotificationService.repositories;

import com.example.TelegramNotificationService.model.Company;
import com.example.TelegramNotificationService.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByCompanyId(Company companyId);
}