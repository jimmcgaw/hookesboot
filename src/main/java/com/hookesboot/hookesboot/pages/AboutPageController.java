package com.hookesboot.hookesboot.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AboutPageController {

    @GetMapping("/about")
    public String serveCustomPage() {
        // Forward to the static file's relative path inside the static folder
        return "forward:/pages/about.html";
    }
}