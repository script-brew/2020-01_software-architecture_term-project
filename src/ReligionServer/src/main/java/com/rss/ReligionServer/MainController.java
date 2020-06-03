package com.rss.ReligionServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MainController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/greeting")
    public String greeting() {
        jdbcTemplate.update("INSERT INTO tb_sample(co_text) VALUES(?)", "Hello world!");
        return "Hello world";
    }
}
