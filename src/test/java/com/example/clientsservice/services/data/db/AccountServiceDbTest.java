package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.enums.Role;
import com.example.clientsservice.services.AccountService;
import com.example.clientsservice.models.Account;
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
public class AccountServiceDbTest {
    @Autowired
    AccountService accountService;
    static Account source = new Account(0L, -2, Role.INTERN, null);
    static Account saved;
    @Test
    @Order(1)
    void save(){
        saved = accountService.save(source);
        System.out.println(saved);

        assertNotNull(saved);
        source = saved;
    }
    @Test
    @Order(2)
    void findById(){
        saved = accountService.findById(source.getId());
        assertNotNull(saved);
        source = saved;
    }
    @Test
    @Order(3)
    void findAll(){
        List<Account> accounts = accountService.findAll();
        assertNotNull(accounts);
    }
    @Test
    @Order(4)
    void remove(){
        accountService.deleteById(source.getId());
    }
}
