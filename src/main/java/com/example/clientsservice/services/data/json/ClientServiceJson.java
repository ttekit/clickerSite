package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.ClientService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.example.clientsservice.devdep.Logger.printInfo;

@Service
public class ClientServiceJson implements ClientService {
    private final String fileName = "client.json";
    private final Gson gson;

    public ClientServiceJson(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Client save(Client client) {
        List<Client> clientList = findAll();
        if(clientList == null){
            clientList = new ArrayList<>();
        }
        client.setId(clientList.get(clientList.size()-1).getId()+1);
        clientList.add(client);
        printInfo(clientList);
        this.saveAll(clientList);
        return client;
    }

    @Override
    public Client findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }


    public void saveAll(List<Client> clients){
        String jStr = gson.toJson(clients);
        try {
            Files.write(Paths.get(fileName), jStr.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public List<Client> findAll() {
        try {
            String jStr = new String(Files.readAllBytes(Paths.get(fileName)));
            return gson.fromJson(jStr, new TypeToken<List<Client>>(){}.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
