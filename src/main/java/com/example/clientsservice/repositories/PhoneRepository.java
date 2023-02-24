package com.example.clientsservice.repositories;

import com.example.clientsservice.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhoneRepository extends JpaRepository<Phone, Integer> {
}
