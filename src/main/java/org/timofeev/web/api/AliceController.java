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
        if (messageFromAlice.getRequest().getCommand().isEmpty()){
            return ResponseByAlice.builder().response(ResponseByAlice.Response.builder().endSession(false).text("Навык готов к использованию").tts("Навык готов к использованию").build()).version("1.0").build();
        }
        if (messageFromAlice.getRequest().getCommand().equalsIgnoreCase("конец") || messageFromAlice.getRequest().getCommand().equalsIgnoreCase("конец списка")){
            telegramService.sendTelegram("=========================================");
            return ResponseByAlice.builder().response(ResponseByAlice.Response.builder().endSession(true).text("").tts("").build()).version("1.0").build();
        }
        log.info(messageFromAlice.toString());
        telegramService.sendTelegram(messageFromAlice.getRequest().getCommand());
        return ResponseByAlice.builder().response(ResponseByAlice.Response.builder().endSession(false).text("Готово").tts("готово").build()).version("1.0").build();
    }
}
