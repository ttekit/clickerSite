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

    @PostMapping("/user/submitRegister")
    private String submitRegister(@RequestBody String str, BCryptPasswordEncoder encoder) {
        Gson gson = new Gson();
        User user = gson.fromJson(str, User.class);
        user.setRole(Role.USER);
        user.setStatus(Status.CREATED);
        user.setPassword(encoder.encode(user.getPassword()));
        printInFixColor(user);

        userService.save(user);
        return "redirect:/";
    }
    @PostMapping("/user/updateUser")
    private String updateUser(@RequestBody String str, BCryptPasswordEncoder encoder) {
        Gson gson = new Gson();
        User userUpdate = gson.fromJson(str, User.class);
        User user = userService.findById(userUpdate.getId());
        if(Objects.equals(userUpdate.getPassword(), "")){
            userUpdate.setPassword(user.getPassword());
        }
        else{
            userUpdate.setPassword(encoder.encode(userUpdate.getPassword()));
        }
        if(!user.equals(userUpdate)){
            userService.save(userUpdate);
        }
        printInFixColor(userUpdate);
        return "redirect:/";
    }

    @GetMapping("/user/ban")
    private String banUser(@RequestParam Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }


}
