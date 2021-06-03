package com.test.telda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @RequestMapping("/error")
    public String error() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Telda</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Something went wrong!</h1>\n" +
                "<h2>Check the entered data</h2>\n" +
                "<a href=\"/\">Home</a>\n" +
                "</body>\n" +
                "</html>";
    }
}
