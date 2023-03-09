package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.services.AddressService;
import com.example.clientsservice.services.PhoneService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.clientsservice.devdep.Logger.printInfo;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class AddressServiceJsonTest {
    @Autowired
    @Qualifier("addressServiceJson")
    AddressService addressService;

    static Address source = new Address(0, "test","test","test","test","test","test","test", null);
    static Address saved;


    @Test
    @Order(1)
    void save() {
        saved = addressService.save(source);
        assertNotNull(saved);
        // assertEquals(source, saved);
        source = saved;
    }

    @Test
    @Order(2)
    void findById() {
        saved = addressService.findById(source.getId());
        assertNotNull(saved);
        source = saved;
    }

    @Test
    @Order(3)
    void saveAll() {
        List<Address> addresses = Collections.singletonList(source);
        addressService.saveAll(addresses);
    }

    @Test
    @Order(4)
    void findAll() {
        List<Address> addresses = addressService.findAll();
        printInfo(Arrays.toString(addresses.toArray()));
        assertNotNull(addresses);
    }

    @Test
    @Order(5)
    void remove() {
        addressService.deleteById(source.getId());
    }
}
