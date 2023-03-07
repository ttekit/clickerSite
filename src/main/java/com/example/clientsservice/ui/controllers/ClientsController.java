package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.enums.Gender;
import com.example.clientsservice.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.clientsservice.devdep.Logger.printInFixColor;
import static com.example.clientsservice.devdep.Logger.printInfo;

@Controller
public class ClientsController {
    @Autowired
    @Qualifier("clientServiceDb")
    ClientService clientService;

    @GetMapping("/clients")
    String load(Model model) {
        printInfo("CLIENTS PAGE");
        List<Client> clientList = clientService.findAll();

        String[] genders = Gender.getNames(Gender.class);
        model.addAttribute("clients", clientList);
        model.addAttribute("genders", genders);
        //return "/client/clients";
        return "/client/mustache/clients";
    }

    @GetMapping("/clients/edit")
    String edit(Model model, @RequestParam("id") Integer id) {
        printInfo("EDIT CLIENT PAGE");
        Client clientList = clientService.findById(id);

        String[] genders = Gender.getNames(Gender.class);
        model.addAttribute("client", clientList);
        model.addAttribute("genders", genders);
        return "/client/mustache/clientsEdit";
        //return "/client/clientsEdit";
    }


    @PostMapping("addClientForm")
    String addClientForm(@ModelAttribute("client") Client client) {
        printInfo("ADD CLIENT FORM");

        clientService.save(client);

        return "redirect:/clients";
    }
    @PostMapping("updateClientForm")
    String updateClientForm(@ModelAttribute("client") Client client) {
        printInfo("UPDATE CLIENT FORM");

        printInFixColor(client);

        clientService.updateClient(client);
        return "redirect:/clients";
    }
    @GetMapping("clientsDelete")
    String deleteClient(@RequestParam Integer id) {
        printInfo("DELETE CLIENT");

        clientService.deleteById(id);
        return "redirect:/clients";
    }
}
