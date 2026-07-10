package com.hookesboot.hookesboot.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageController {

    @GetMapping({"", "/"})
    public String index() {
        // Points directly to src/main/resources/templates/index.html
        return "index"; 
    }
}