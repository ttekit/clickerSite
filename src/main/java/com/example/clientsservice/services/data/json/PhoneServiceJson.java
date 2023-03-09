package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.services.PhoneService;
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

public class PhoneServiceJson implements PhoneService {
    private final String fileName = "phones.json";
    private final Gson gson;
    public PhoneServiceJson(Gson gson){
        this.gson = gson;
    }
    @Override
    public Phone save(Phone phone) {
        List<Phone> phoneList = findAll();
        if(phoneList == null){
            phoneList = new ArrayList<>();
        }
        phone.setId(phoneList.get(phoneList.size()-1).getId()+1);
        phoneList.add(phone);
        printInfo(phoneList);
        this.saveAll(phoneList);
        return phone;
    }

    @Override
    public Phone findById(Integer id) {
        List<Phone> addressList = findAll();
        for (Phone phone : addressList) {
            if (Objects.equals(phone.getId(), id)) {
                return phone;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Phone> findAll() {
        try {
            String jStr = new String(Files.readAllBytes(Paths.get(fileName)));
            return gson.fromJson(jStr, new TypeToken<List<Phone>>(){}.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll(List<Phone> phones) {
        String jStr = gson.toJson(phones);
        try {
            Files.write(Paths.get(fileName), jStr.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
