package com.example.TelegramNotificationService.bot;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${bot.name}")
    private String name;


    @Value("${bot.token}")
    private final String token;


    public TelegramBot(@Value("${bot.token}") String botToken) {
        this.token = botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("Received message from user");

        long chatId = update.getMessage().getChatId();
        String messageText = "Ваш chat id = `"
                + chatId
                + "`\nДля получения уведомлений введите его в форму на странице профиля на сайте.";

        SendMessage message = new SendMessage();
        message.enableMarkdown(true);
        message.setChatId(String.valueOf(chatId));
        message.setText(messageText);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Failed to send message \"{}\"", messageText);
            log.error("Exception", e);
        }
    }

    public void sendMessage(long chatId, String text) throws TelegramApiException {
        try {
            SendMessage command = new SendMessage();
            command.enableHtml(true);
            command.disableWebPagePreview();
            command.setChatId(String.valueOf(chatId));
            command.setText(text);

            this.execute(command);
        } catch (TelegramApiException e) {

            log.error("Exception", e);
            throw e;
        }
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}