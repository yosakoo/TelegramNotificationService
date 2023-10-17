package com.example.TelegramNotificationService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "company")
@NamedQuery(name = "Company.findByCompanyTag", query = "SELECT c FROM Company c WHERE c.company_tag = :companyTag")

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String company_tag;

    @Column(nullable = false)
    private String company_name;
}