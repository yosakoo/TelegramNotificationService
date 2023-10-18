package com.example.TelegramNotificationService.service;

import com.example.TelegramNotificationService.bot.TelegramBot;
import com.example.TelegramNotificationService.model.Company;
import com.example.TelegramNotificationService.model.News;

import com.example.TelegramNotificationService.model.Subscription;
import com.example.TelegramNotificationService.repositories.CompanyRepository;
import com.example.TelegramNotificationService.repositories.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    private final TelegramBot telegramBot;

    private final SubscriptionService subscriptionService;
    private final SubscriptionRepository subscriptionRepository;

    private final CompanyRepository companyRepository;

    @SneakyThrows
    @Override
    public void handle(News news) {
        String tag = news.getCompany_tag();
        Company company = companyRepository.findBycompanyTag(tag);

        List<Subscription> list = subscriptionService.findByCompanyTag(company);
        log.info(tag);
        for (Subscription id:list) {
            System.out.println("ID:" + id.toString());
        }

    }

}