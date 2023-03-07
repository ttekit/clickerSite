package com.example.clientsservice.services.data.db;

import com.example.clientsservice.services.AddressService;
import com.example.clientsservice.models.Address;
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
public class AddressServiceDbTest {
    @Autowired
    AddressService addressService;
    static Address source = new Address(0, "test", "test", "test", "test", "test", "test", "Test", null);
    static Address saved;
    @Test
    @Order(1)
    void save(){
        saved = addressService.save(source);

        assertNotNull(saved);
        source = saved;
    }
    @Test
    @Order(2)
    void findById(){
        saved = addressService.findById(source.getId());
        assertNotNull(saved);
        source = saved;
    }
    @Test
    @Order(3)
    void findAll(){
        List<Address> addresses = addressService.findAll();
        assertNotNull(addresses);
    }
    @Test
    @Order(4)
    void remove(){
        addressService.deleteById(source.getId());
    }

}
