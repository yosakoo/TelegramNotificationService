package com.example.TelegramNotificationService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "telegram_chat_id")
    private Users user_telegram_chat_id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyId;
}