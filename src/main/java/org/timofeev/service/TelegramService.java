package org.timofeev.service;

import org.springframework.stereotype.Component;

@Component
public interface TelegramService {
    void sendTelegram(String message);
}
