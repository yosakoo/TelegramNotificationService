package com.example.TelegramNotificationService.repositories;

import com.example.TelegramNotificationService.model.Company;
import com.example.TelegramNotificationService.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByAllBYCompanyTag(String companyTag);
}