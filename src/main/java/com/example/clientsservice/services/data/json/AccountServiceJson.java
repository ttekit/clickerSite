package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.AccountService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.clientsservice.devdep.Logger.printInfo;

@Service
public class AccountServiceJson implements AccountService {
    private final String fileName = "account.json";
    private final Gson gson;

    public AccountServiceJson(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Account save(Account account) {
        List<Account> accountList = findAll();
        if(accountList == null){
            accountList = new ArrayList<>();
            account.setId(1L);
        }
        else{
            account.setId(accountList.get(accountList.size()-1).getId()+1);
        }
        accountList.add(account);
        printInfo(accountList);
        this.saveAll(accountList);
        return account;
    }

    @Override
    public Account findById(Long id) {
        List<Account> accountList = findAll();
        for (Account account : accountList) {
            if (Objects.equals(account.getId(), id)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Account> findAll() {
        try {
            String jStr = new String(Files.readAllBytes(Paths.get(fileName)));
            return gson.fromJson(jStr, new TypeToken<List<Account>>(){}.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveAll(List<Account> accountList){
        String jStr = gson.toJson(accountList);
        try {
            Files.write(Paths.get(fileName), jStr.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
