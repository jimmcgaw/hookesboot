package com.hookesboot.hookesboot.chat;

public class ChatDto {
    // Incoming request payload from the browser
    public record Request(String message) {}

    // Outgoing response payload back to the browser
    public record Response(String reply) {}
}