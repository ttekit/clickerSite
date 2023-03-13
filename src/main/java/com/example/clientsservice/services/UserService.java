package com.example.clientsservice.services;

import com.example.clientsservice.models.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    User save(User user);
    User findById(Integer id);
    void deleteById(Integer id);
    List<User> findAll();
    List<User> saveAll(List<User> users);
}
