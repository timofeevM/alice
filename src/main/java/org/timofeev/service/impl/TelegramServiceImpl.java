package org.timofeev.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.timofeev.domain.TelegramBot;
import org.timofeev.service.TelegramService;

@Component
@RequiredArgsConstructor
public class TelegramServiceImpl implements TelegramService {
    private final TelegramBot telegramBot;

    @Override
    public void sendTelegram(String message) {
        telegramBot.sendMessage(message);
    }
}
