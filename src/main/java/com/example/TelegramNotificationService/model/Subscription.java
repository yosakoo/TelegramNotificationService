package com.example.TelegramNotificationService.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_telegram_chat_id")
    private User userTelegramChatId;

    @ManyToOne
    @JoinColumn(name = "company_tag")
    private Company companyTag;
}