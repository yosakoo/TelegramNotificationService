package com.example.TelegramNotificationService.repositories;

import com.example.TelegramNotificationService.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findBycompanyTag(String companyTag);
}
