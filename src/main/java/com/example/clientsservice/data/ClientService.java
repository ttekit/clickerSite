package com.example.clientsservice.data;

import com.example.clientsservice.models.Client;

import java.util.List;

public interface ClientService{
    Client save(Client client);
    Client findById(Integer id);
    void deleteById(Integer id);

    List<Client> findAll();
}
