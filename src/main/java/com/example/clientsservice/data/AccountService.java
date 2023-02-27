package com.example.clientsservice.data;

import com.example.clientsservice.models.Account;

import java.util.List;

public interface AccountService {
    Account save(Account account);
    Account findById(Long id);
    void deleteById(Long id);

    List<Account> findAll();
}
