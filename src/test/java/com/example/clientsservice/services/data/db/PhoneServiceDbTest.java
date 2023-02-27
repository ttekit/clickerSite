package com.example.clientsservice.services.data.db;

import com.example.clientsservice.data.PhoneService;
import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Phone;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PhoneServiceDbTest {
    @Autowired
    PhoneService phoneService;
    static Phone source = new Phone(0, "+380992362606", null);
    static Phone saved;

    @Test
    @Order(1)
    void save(){
        saved = phoneService.save(source);
        System.out.println(saved);

        assertNotNull(saved);
        source = saved;
    }
    @Test
    @Order(2)
    void findById(){
        saved = phoneService.findById(source.getId());
        assertNotNull(saved);
        source = saved;
    }
    @Test
    @Order(3)
    void findAll(){
        List<Phone> phones = phoneService.findAll();
        assertNotNull(phones);
    }
    @Test
    @Order(4)
    void remove(){
        phoneService.deleteById(source.getId());
    }
}
