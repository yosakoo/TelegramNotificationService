package com.example.TelegramNotificationService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company_tag" , nullable = false, unique = true)
    private String companyTag;

    @Column(name = "company_name",nullable = false)
    private String companyName;
}