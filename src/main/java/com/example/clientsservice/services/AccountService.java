package com.example.clientsservice.services;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Address;

import java.util.List;

public interface AccountService {
    Account save(Account account);
    Account findById(Long id);
    void deleteById(Long id);

    List<Account> findAll();
    void saveAll(List<Account> addresses);
}
