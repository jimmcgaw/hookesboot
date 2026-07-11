package com.hookesboot.hookesboot.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AboutPageController {

    @GetMapping("/about")
    public String about() {
        // Points directly to src/main/resources/templates/about.html
        return "about";
    }
}