package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.enums.Gender;
import com.example.clientsservice.services.ClientService;
import com.example.clientsservice.models.Client;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceDbTest {
    @Qualifier("clientServiceDb")
    @Autowired
    ClientService clientService;
    static Client source = new Client(0, "tester", "tester", "tester", "tester@tester.teseter", LocalDate.EPOCH, Gender.IDE, null, null, null);
    static Client saved;

    @Test
    @Order(1)
    void save() {
        saved = clientService.save(source);
        System.out.println(saved);

        assertNotNull(saved);
        // assertEquals(source, saved);
        source = saved;
    }

    @Test
    @Order(2)
    void findById() {
        saved = clientService.findById(source.getId());
        assertNotNull(saved);
        source = saved;
    }

    @Test
    @Order(3)
    void findAll() {
        List<Client> clients = clientService.findAll();
        assertNotNull(clients);
    }

    @Test
    @Order(4)
    void remove() {
        clientService.deleteById(source.getId());
    }
}
