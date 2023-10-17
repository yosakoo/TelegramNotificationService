package com.example.TelegramNotificationService.repositories;

import com.example.TelegramNotificationService.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("SELECT c FROM Company c WHERE c.company_tag = :companyTag")
    Company findByCompanyTag(@Param("companyTag") String companyTag);
}