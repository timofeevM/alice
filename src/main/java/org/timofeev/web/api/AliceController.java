package org.timofeev.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.timofeev.domain.MessageFromAlice;
import org.timofeev.service.TelegramService;

@RestController
@RequiredArgsConstructor
public class AliceController {

    private final TelegramService telegramService;

    @PostMapping("/send_to_telegram")
    public void sendToTelegram(@RequestBody MessageFromAlice messageFromAlice) {
        telegramService.sendTelegram(messageFromAlice.getRequest().getOriginalUtterance());
    }
}
