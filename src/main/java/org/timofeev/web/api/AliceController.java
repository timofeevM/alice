package org.timofeev.web.api;

import lombok.RequiredArgsConstructor;
import org.jscience.physics.amount.Amount;
import org.jscience.physics.model.RelativisticModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.timofeev.domain.MessageFromAlice;
import org.timofeev.service.TelegramService;

import javax.measure.quantity.Mass;
import java.util.Map;

import static javax.measure.unit.SI.KILOGRAM;

@RestController
@RequiredArgsConstructor
public class AliceController {

    private final TelegramService telegramService;

    @PostMapping("/send_to_telegram")
    public void sendToTelegram(@RequestBody MessageFromAlice messageFromAlice) {
        telegramService.sendTelegram(messageFromAlice.getRequest().getOriginalUtterance());
    }

    @RequestMapping("/hello")
    String hello(Map<String, Object> model) {
        RelativisticModel.select();
        Amount<Mass> m = Amount.valueOf("12 GeV").to(KILOGRAM);
        model.put("science", "E=mc^2: 12 GeV = " + m.toString());
        return "hello";
    }
}
