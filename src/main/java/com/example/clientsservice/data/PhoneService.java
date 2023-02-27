package com.example.clientsservice.data;

import com.example.clientsservice.models.Phone;

import java.util.List;

public interface PhoneService {
    Phone save(Phone phone);
    Phone findById(Integer id);
    void deleteById(Integer id);

    List<Phone> findAll();
}
