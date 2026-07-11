package com.hookesboot.hookesboot.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatUiController {

    @GetMapping("/chat")
    public String showChatPage() {
        // Serves src/main/resources/templates/chat.html
        return "chat";
    }
}