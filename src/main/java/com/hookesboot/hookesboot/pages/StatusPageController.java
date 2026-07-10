package com.hookesboot.hookesboot.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StatusPageController {

    @GetMapping("/status")
    public String status() {
        return "status"; 
    }
}