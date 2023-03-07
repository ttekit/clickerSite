package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.enums.Gender;
import com.example.clientsservice.services.ClientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.clientsservice.devdep.Logger.printInfo;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceJsonTest {
    @Autowired
    @Qualifier("clientServiceJson")
    ClientService clientServiceJson;
    static Client source = new Client(0, "tester", "tester", "tester", "tester@tester.teseter", LocalDate.EPOCH, Gender.IDE, null, null, null);
    static Client saved;

    @Test
    @Order(1)
    void save() {
        saved = clientServiceJson.save(source);

        assertNotNull(saved);
        // assertEquals(source, saved);
        source = saved;
    }

    @Test
    @Order(2)
    void findById() {
        saved = clientServiceJson.findById(source.getId());
        assertNotNull(saved);
        source = saved;
    }

    @Test
    @Order(3)
    void saveAll() {
        List<Client> clients = Collections.singletonList(source);
        clientServiceJson.saveAll(clients);
    }

    @Test
    @Order(4)
    void findAll() {
        List<Client> clients = clientServiceJson.findAll();
        printInfo(Arrays.toString(clients.toArray()));
        assertNotNull(clients);
    }

    @Test
    @Order(5)
    void remove() {
        clientServiceJson.deleteById(source.getId());
    }
}
