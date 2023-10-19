package com.example.TelegramNotificationService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "telegram_chat_id", referencedColumnName = "telegram_chat_id")
    private User user_telegram_chat_id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyId;
}