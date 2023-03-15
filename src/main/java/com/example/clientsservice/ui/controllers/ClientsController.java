package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.enums.Gender;
import com.example.clientsservice.services.AddressService;
import com.example.clientsservice.services.ClientService;
import com.example.clientsservice.services.data.database.AddressServiceDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.view.ThymeleafView;

import java.util.List;

import static com.example.clientsservice.devdep.Logger.printInFixColor;
import static com.example.clientsservice.devdep.Logger.printInfo;

@Controller
public class ClientsController {
    @Autowired
    @Qualifier("clientServiceDb")
    ClientService clientService;
    @Autowired
    @Qualifier("addressServiceDb")
    AddressService addressService;


    @Bean(name = "content-part")
    @Scope("prototype")
    public ThymeleafView clientsViewBean() {
        printInFixColor("CLIENTS VIEW BEEN WORKED");
        ThymeleafView view = new ThymeleafView("index"); // templateName = 'index'
        view.setMarkupSelector("content");
        return view;
    }


    @GetMapping("/clients")
    String load(Model model) {
        List<Client> clientList = clientService.findAll();

        String[] genders = Gender.getNames();
        model.addAttribute("clients", clientList);
        model.addAttribute("genders", genders);

        return "/client/clients";
        //return "/client/mustache/clients";
    }

    @GetMapping("/clients/edit")
    String edit(Model model, @RequestParam("id") Integer id) {
        Client client = clientService.findById(id);

        String[] genders = Gender.getNames();
        model.addAttribute("client", client);
        model.addAttribute("address", (client.getAddress() == null ? new Address() : client.getAddress()));
        model.addAttribute("genders", genders);
        //return "/client/mustache/clientsEdit";
        return "/client/clientsEdit";
    }

    @PostMapping("/clients/updateClientAddress")
    String edit(@ModelAttribute("address") Address address) {
        printInFixColor(address);
        printInFixColor(address.getClient());
        Client client = address.getClient();
        address.setClient(null);
        client.setAddress(address);

        addressService.save(address);
        clientService.save(client);
        return "redirect:/clients";
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
