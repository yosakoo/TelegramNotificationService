package com.example.TelegramNotificationService.service;

import com.example.TelegramNotificationService.model.Company;
import com.example.TelegramNotificationService.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    public Company getCompanyByCompanyTag(String tag){
        return companyRepository.findByCompanyTag(tag);
    }

}
