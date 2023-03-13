package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.User;
import com.example.clientsservice.services.UserService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceDbTest {
    @Autowired
    UserService userService;
    @Autowired
    User userActual;
    @Autowired
    User userExpected;
    @Autowired
    List<User> listActual;
    ArrayList<User> listExpected;


    @Test
    void save() {
        userActual = userService.save(userExpected);
        assertEquals(userExpected, userActual);
    }

    @Test
    void saveAll() {
        listActual = userService.saveAll(listExpected);
        System.err.println(listActual);
    }
}
