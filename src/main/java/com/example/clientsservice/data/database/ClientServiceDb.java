package com.example.clientsservice.data.database;

import com.example.clientsservice.data.ClientService;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceDb implements ClientService {
    @Autowired
    private ClientRepository clientRepository;


    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }
    @Override
    public Client findById(Integer id){
        return clientRepository.findById(id).orElse(null);
    }
    public void deleteById(Integer id){
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
