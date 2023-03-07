package com.example.clientsservice.services;

import com.example.clientsservice.models.Client;

import java.util.List;

public interface ClientService{
    Client save(Client client);
    Client findById(Integer id);
    void deleteById(Integer id);
    void saveAll(List<Client> clients);
    void updateClient(Client client);
    List<Client> findAll();
}
