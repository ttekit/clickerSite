package com.example.clientsservice.ui.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class MainController {
    @GetMapping("/")
    String load(){
        return "main/index";
    }
}
