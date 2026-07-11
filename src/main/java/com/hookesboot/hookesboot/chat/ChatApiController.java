package com.hookesboot.hookesboot.chat;

import org.springframework.ai.chat.client.ChatClient;
// import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatApiController {

    private final ChatClient chatClient;

    public ChatApiController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @PostMapping("/api/chat")
    public ChatDto.Response handleComplexChat(@RequestBody ChatDto.Request request) {
        String response = this.chatClient.prompt()
                .user(request.message())
                // 💡 Programmatically route using OllamaChatOptions
                // .options(OllamaChatOptions.builder()
                //         .model("mistral")
                //         .temperature(0.4))
                .call()
                .content();

        return new ChatDto.Response(response);
    }
}