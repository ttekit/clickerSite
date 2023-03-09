package com.example.clientsservice.ui.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/clients").setViewName("/client/clients");
        registry.addViewController("/accounts").setViewName("/account/accounts");
        registry.addViewController("/login").setViewName("/login/login");
        registry.addViewController("/register").setViewName("/register/register");

        WebMvcConfigurer.super.addViewControllers(registry);
    }

}
