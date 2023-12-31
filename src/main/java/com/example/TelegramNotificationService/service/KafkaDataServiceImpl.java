package com.example.TelegramNotificationService.service;

import com.example.TelegramNotificationService.bot.TelegramBot;
import com.example.TelegramNotificationService.model.Company;
import com.example.TelegramNotificationService.model.News;
import com.example.TelegramNotificationService.model.Subscription;
import com.example.TelegramNotificationService.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    private final TelegramBot telegramBot;
    private final SubscriptionService subscriptionService;
    private final CompanyRepository companyRepository;


    @SneakyThrows
    @Override
    public void handle(News news) {
        String tag = news.getCompany_tag();
        Company Id = companyRepository.findBycompanyTag(tag);
        List<Subscription> list = subscriptionService.findByCompanyId(Id);

        log.info("ID: " + Id);
        for (Subscription id : list) {
            telegramBot.sendMessage(id.getUser_telegram_chat_id().getTelegram_chat_id(), news.getContent());
        }

    }

}