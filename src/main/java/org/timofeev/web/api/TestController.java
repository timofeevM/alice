package org.timofeev.web.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/")
    String hello() {
        return "<!DOCTYPE html><html lang=\"EN\"><body><div>Hello</div></body></html>";
    }
}
