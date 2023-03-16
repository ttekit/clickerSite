package com.example.clientsservice.ui.controllers.rest;

import com.example.clientsservice.models.User;
import com.example.clientsservice.models.enums.Role;
import com.example.clientsservice.models.enums.Status;
import com.example.clientsservice.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.example.clientsservice.devdep.Logger.printInFixColor;

@RestController
public class UserRestController {
    @Autowired
    @Qualifier("userServiceDb")
    UserService userService;

    @PostMapping("/rest/user/submitRegister")
    private String submitRegister(@RequestBody String str, BCryptPasswordEncoder encoder) {
        Gson gson = new Gson();
        User user = gson.fromJson(str, User.class);
        user.setRole(Role.USER);
        user.setStatus(Status.CREATED);
        user.setPassword(encoder.encode(user.getPassword()));
        printInFixColor(user);

        user = userService.save(user);
        if (user != null) {
            return "success";
        }
        return "error, try later pls";
    }

    @PostMapping("/rest/user/updateUser")
    private String updateUser(@RequestBody String str, BCryptPasswordEncoder encoder) {
        Gson gson = new Gson();
        User userUpdate = gson.fromJson(str, User.class);
        User user = userService.findById(userUpdate.getId());
        if (Objects.equals(userUpdate.getPassword(), "")) {
            userUpdate.setPassword(user.getPassword());
        } else {
            userUpdate.setPassword(encoder.encode(userUpdate.getPassword()));
        }
        if (!user.equals(userUpdate)) {
            userService.save(userUpdate);
        }
        printInFixColor(userUpdate);
        if (userUpdate != null) {

            return "success";
        } else {
            return "error";
        }
    }

}
