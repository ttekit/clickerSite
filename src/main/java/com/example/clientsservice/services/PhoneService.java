package com.example.clientsservice.services;

import com.example.clientsservice.models.Phone;

import java.util.List;

public interface PhoneService {
    Phone save(Phone phone);
    Phone findById(Integer id);
    void deleteById(Integer id);

    List<Phone> findAll();
    void saveAll(List<Phone> phones);
}
