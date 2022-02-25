package org.timofeev.web.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.timofeev.domain.MessageFromAlice;
import org.timofeev.domain.ResponseByAlice;
import org.timofeev.service.TelegramService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AliceController {

    private final TelegramService telegramService;

    @PostMapping("/send_to_telegram")
    public ResponseByAlice sendToTelegram(@RequestBody MessageFromAlice messageFromAlice) {
        log.info(messageFromAlice.toString());
        telegramService.sendTelegram(messageFromAlice.getRequest().getOriginalUtterance());
        return ResponseByAlice.builder().response(ResponseByAlice.Response.builder().endSession(false).text("Готово").tts("готово").build()).version("1.0").build();
    }
}
