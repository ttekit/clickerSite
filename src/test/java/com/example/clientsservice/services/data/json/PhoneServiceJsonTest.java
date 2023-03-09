package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Phone;
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

public class PhoneServiceJsonTest {
    @Autowired
    @Qualifier("phoneServiceJson")
    PhoneService phoneService;
    static Phone source = new Phone(0, "+380996320224", null);
    static Phone saved;

    @Test
    @Order(1)
    void save() {
        saved = phoneService.save(source);
        assertNotNull(saved);
        // assertEquals(source, saved);
        source = saved;
    }

    @Test
    @Order(2)
    void findById() {
        saved = phoneService.findById(source.getId());
        assertNotNull(saved);
        source = saved;
    }

    @Test
    @Order(3)
    void saveAll() {
        List<Phone> phones = Collections.singletonList(source);
        phoneService.saveAll(phones);
    }

    @Test
    @Order(4)
    void findAll() {
        List<Phone> phones = phoneService.findAll();
        printInfo(Arrays.toString(phones.toArray()));
        assertNotNull(phones);
    }

    @Test
    @Order(5)
    void remove() {
        phoneService.deleteById(source.getId());
    }
}
