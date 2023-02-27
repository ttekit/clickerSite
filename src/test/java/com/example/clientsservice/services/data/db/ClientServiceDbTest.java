package com.example.clientsservice.services.data.db;

import com.example.clientsservice.data.ClientService;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.Gender;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.clientsservice.devdep.Logger.printError;
import static com.example.clientsservice.devdep.Logger.printInFixColor;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceDbTest {
    @Autowired
    ClientService clientService;
    static Client source = new Client(0, "tester", "tester", "tester", "tester@tester.teseter", LocalDate.EPOCH, Gender.SETOFF, null, null, null);
    static Client saved;
    @Test
    @Order(1)
    void save(){
        saved = clientService.save(source);
        System.out.println(saved);

        assertNotNull(saved);
        // assertEquals(source, saved);
        source = saved;
    }
    @Test
    @Order(2)
    void findById(){
        saved = clientService.findById(source.getId());
        assertNotNull(saved);
        source = saved;
    }
    @Test
    @Order(3)
    void findAll(){
        List<Client> clients = clientService.findAll();
        assertNotNull(clients);
    }
    @Test
    @Order(4)
    void remove(){
        clientService.deleteById(source.getId());
    }
}
