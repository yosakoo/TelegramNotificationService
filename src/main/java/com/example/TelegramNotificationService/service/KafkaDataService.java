package com.example.TelegramNotificationService.service;

import com.example.TelegramNotificationService.model.News;

public interface KafkaDataService {

    void handle(News news);

}