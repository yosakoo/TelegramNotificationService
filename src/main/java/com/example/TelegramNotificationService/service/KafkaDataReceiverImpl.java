package com.example.TelegramNotificationService.service;


import com.example.TelegramNotificationService.bot.TelegramBot;
import com.example.TelegramNotificationService.model.News;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;


@Service
@RequiredArgsConstructor
public class KafkaDataReceiverImpl implements KafkaDataReceiver {

    private final KafkaReceiver<String, Object> receiver;

    private final KafkaDataService kafkaDataService;
    private final TelegramBot telegramBot;
    @PostConstruct
    private void init() {
        fetch();
    }

    @Override
    public void fetch() {
        Gson gson = new GsonBuilder()
                .create();
        receiver.receive()
                .subscribe(r -> {
                    News news = gson
                            .fromJson(r.value().toString(), News.class);
                    kafkaDataService.handle(news);
                    r.receiverOffset().acknowledge();
                });
    }

}