package org.timofeev.domain;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "TimofeevAliceBot";
    }

    @Override
    public String getBotToken() {
        return "5141160503:AAF_lfvalwqyVg3s886n-b0btQV4duNTYaY";
    }

    @Override
    public void onUpdateReceived(Update update) {
    }

    public void sendMessage(String message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId("-760188556");
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
