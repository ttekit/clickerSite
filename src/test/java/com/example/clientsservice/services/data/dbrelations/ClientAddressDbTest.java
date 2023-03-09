package com.example.clientsservice.services.data.dbrelations;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.enums.Gender;
import com.example.clientsservice.services.AddressService;
import com.example.clientsservice.services.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class ClientAddressDbTest {
    @Qualifier("clientServiceDb")
    @Autowired
    ClientService clientService;

    @Qualifier("addressServiceDb")
    @Autowired
    AddressService addressService;

    static Client client = new Client(0, "Tester", "tester", "tester", "tester@tester.ddddftester", LocalDate.now(), Gender.IDE, null, null, null);
    static Address address = new Address(0, "Ukraine", "Idk", "Idk", "Testeria", "testeria", "-2", "0", null);

    @Test
    void save(){
        client = clientService.save(client);
        address = addressService.save(address);
        client.setAddress(address);
        clientService.save(client);
    }
}

