package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public TaskResponse response(TaskMessage message) throws Exception {
        Thread.sleep(1000);
        String fileName = message.getFileName();
        System.out.println(fileName);
        //search from db, get information and provide it
        return new TaskResponse("I will answer soon for this file ");
    }
}
