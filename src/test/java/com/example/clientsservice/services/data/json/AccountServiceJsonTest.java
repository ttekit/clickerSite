package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.models.enums.Role;
import com.example.clientsservice.services.AccountService;
import com.example.clientsservice.services.AddressService;
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

public class AccountServiceJsonTest {
    @Autowired
    @Qualifier("accountServiceJson")
    AccountService accountService;
    static Account source = new Account(0l, -2, Role.ARCHITECTOR, null);

    static Account saved;

    @Test
    @Order(1)
    void save() {
        saved = accountService.save(source);
        assertNotNull(saved);
        // assertEquals(source, saved);
        source = saved;
    }

    @Test
    @Order(2)
    void findById() {
        saved = accountService.findById(source.getId());
        assertNotNull(saved);
        source = saved;
    }

    @Test
    @Order(3)
    void saveAll() {
        List<Account> accounts = Collections.singletonList(source);
        accountService.saveAll(accounts);
    }

    @Test
    @Order(4)
    void findAll() {
        List<Account> accounts = accountService.findAll();
        printInfo(Arrays.toString(accounts.toArray()));
        assertNotNull(accounts);
    }

    @Test
    @Order(5)
    void remove() {
        accountService.deleteById(source.getId());
    }

}
