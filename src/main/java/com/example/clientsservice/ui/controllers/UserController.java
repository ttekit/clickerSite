package com.example.clientsservice.ui.controllers;


import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.User;
import com.example.clientsservice.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import static com.example.clientsservice.devdep.Logger.printInFixColor;
import static com.example.clientsservice.devdep.Logger.printInfo;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/register")
    private String register() {
        return "/register/register";
    }
    @PostMapping("/user/submitRegister")
    private String submitRegister(@RequestBody String str){
        Gson gson = new Gson();
        User user = gson.fromJson(str, User.class);
        printInFixColor(user);
        //TODO: validation ibo zhas len)
        userService.save(user);
        return "redirect: /user";
    }


}
