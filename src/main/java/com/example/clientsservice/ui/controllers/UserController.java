package com.example.clientsservice.ui.controllers;


import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.User;
import com.example.clientsservice.models.enums.Role;
import com.example.clientsservice.models.enums.Status;
import com.example.clientsservice.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Arrays;
import java.util.Objects;

import static com.example.clientsservice.devdep.Logger.printInFixColor;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/register")
    private String register() {
        return "/register/register";
    }

    @GetMapping("/users")
    private String main(Model model) {
        printInFixColor(Arrays.toString(Role.getNames()));
        printInFixColor(Arrays.toString(Status.getNames()));
        model.addAttribute("statuses", Status.getNames());
        model.addAttribute("roles", Role.getNames());
        model.addAttribute("users", userService.findAll());
        return "/user/main";
    }

    @GetMapping("/user/ban")
    private String banUser(@RequestParam Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }


}
