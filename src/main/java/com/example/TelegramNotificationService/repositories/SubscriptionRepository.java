package com.example.TelegramNotificationService.repositories;

import com.example.TelegramNotificationService.model.Company;
import com.example.TelegramNotificationService.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query(value = "SELECT s.id, s.company_tag, s.user_telegram_chat_id FROM Subscription s WHERE s.company_tag::text = :companyTag", nativeQuery = true)
    List<Subscription> findByCompanyTag(Company companyTag);
}