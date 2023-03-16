package com.example.clientsservice.ui.controllers.rest;

import com.example.clientsservice.ClientsServiceApplication;
import com.example.clientsservice.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientsRestController {
    @Autowired
    @Qualifier("clientServiceDb")
    ClientService clientService;
//
//    @PostMapping("test")
//    public ResponseEntity<String> test(){
//      return new ResponseEntity<String>("ok");
//    };
}
