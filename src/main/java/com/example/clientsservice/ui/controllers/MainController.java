package com.example.clientsservice.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    String load(){
        return "redirect:/clients";
    }
}
