package com.hookesboot.hookesboot.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class StatusApiController {

    @GetMapping("/api/status")
    public Map<String, Object> getQuickData() {
        // Construct an inline, hard-coded key-value map
        return Map.of(
            "status", "online",
            "message", "Hello from Spring AI backend",
            "version", 1.0
        );
    }

    // Define the JSON structure as a clean Java record inside the same file
    public record ModelStatus(String modelName, String provider, boolean isLocal, List<String> capabilities) {}

    @GetMapping("/api/model/status")
    public ModelStatus getStatus() {
        // Return a hard-coded instance of the record
        return new ModelStatus(
            "llama3.2",
            "Ollama",
            true,
            List.of("chat", "embeddings", "tools")
        );
    }
    
}
