package com.test.telda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Telda</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Hello!</h1>\n" +
                "<ul>\n" +
                "    <li><a href=\"/region/all\">Find all</a></li>\n" +
                "    <li><a href=\"/region/id/1\">Find by id</a></li>\n" +
                "    <li><a href=\"/region/name/moscow\">Find by name</a></li>\n" +
                "    <li><a href=\"/region/abbreviatedName/MSK\">Find by abbreviated name</a></li>\n" +
                "</ul>\n" +
                "</body>\n" +
                "</html>";
    }
}
