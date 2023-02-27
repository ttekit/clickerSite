package com.example.clientsservice.services;

import com.example.clientsservice.ClientsServiceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.clientsservice.devdep.Logger.printFix;

@SpringBootTest
class ClientsServiceApplicationTests {

	@Autowired
	ClientsServiceApplication application;
	@Test
	void contextLoads() {
		printFix(application);
	}

}
