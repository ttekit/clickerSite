package com.example.clientsservice.services.data.database;

import com.example.clientsservice.models.Phone;
import com.example.clientsservice.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceDb implements com.example.clientsservice.services.PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;


    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public Phone findById(Integer id) {
        return phoneRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public List<Phone> findAll() {
         return phoneRepository.findAll();
    }
}
