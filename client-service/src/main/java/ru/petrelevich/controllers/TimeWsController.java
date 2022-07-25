package ru.petrelevich.controllers;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
public class TimeWsController {
    private final SimpMessagingTemplate template;

    public TimeWsController(SimpMessagingTemplate template) {
        this.template = template;
    }

    public void broadcastCurrentTime() {
        //template.convertAndSend("/topic/currentTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
    }
}
