package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.AddressService;
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

public class AddressServiceJson implements AddressService {
    private final String fileName = "address.json";
    private final Gson gson;
    public AddressServiceJson(Gson gson) {
        this.gson = gson;
    }
    @Override
    public Address save(Address address) {
        List<Address> clientList = findAll();
        if(clientList == null){
            clientList = new ArrayList<>();
        }
        address.setId(clientList.get(clientList.size()-1).getId()+1);
        clientList.add(address);
        printInfo(clientList);
        this.saveAll(clientList);
        return address;
    }

    @Override
    public Address findById(Integer id) {
        List<Address> addressList = findAll();
        for (Address address : addressList) {
            if (Objects.equals(address.getId(), id)) {
                return address;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Address> findAll() {
        try {
            String jStr = new String(Files.readAllBytes(Paths.get(fileName)));
            return gson.fromJson(jStr, new TypeToken<List<Address>>(){}.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll(List<Address> addresses) {
        String jStr = gson.toJson(addresses);
        try {
            Files.write(Paths.get(fileName), jStr.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
