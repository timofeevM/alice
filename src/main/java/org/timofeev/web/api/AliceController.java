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
        String message = null;
        if (messageFromAlice.getRequest().getCommand().contains("алиса")){
            message = messageFromAlice.getRequest().getCommand().replaceAll("алиса ", messageFromAlice.getRequest().getCommand());
        }
        if (message==null){
            message = messageFromAlice.getRequest().getCommand();
        }
        if (message.isEmpty()){
            return ResponseByAlice.builder().response(ResponseByAlice.Response.builder().endSession(false).text("Навык готов к использованию").tts("Навык готов к использованию").build()).version("1.0").build();
        }
        if (message.equalsIgnoreCase("конец") || message.equalsIgnoreCase("закончи список")){
            telegramService.sendTelegram("==========================");
            return ResponseByAlice.builder().response(ResponseByAlice.Response.builder().endSession(true).text("").tts("").build()).version("1.0").build();
        }
        telegramService.sendTelegram(message);
        return ResponseByAlice.builder().response(ResponseByAlice.Response.builder().endSession(false).text("Готово").tts("готово").build()).version("1.0").build();
    }
}
