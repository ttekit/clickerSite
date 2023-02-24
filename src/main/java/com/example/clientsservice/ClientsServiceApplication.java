package com.example.clientsservice;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.Gender;
import com.example.clientsservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;

import static com.example.clientsservice.devdep.Logger.*;

@SpringBootApplication
public class ClientsServiceApplication {
	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args)
	{
		SpringApplication.run(ClientsServiceApplication.class, args);

	}
//	@PostConstruct
	@EventListener(ApplicationReadyEvent.class)
	public void onReady(){
		System.out.println("APPLICATION LOADED!");
		Client client = new Client(0, "Akakiy", "Byt", "Akakievich", "akakiy@gmail.com", LocalDate.EPOCH, Gender.DOG,
				null, null, null);
		//Address address = new Address(0, "Ukraine", "Kyiv", "Kyiv Oblast", "Apt. 9,", "Velyka Vasylkivska Street", "47", "9", client);
		cls();
		//client.setAddress(address);
		//clientRepository.save(client);
		printInfo(clientRepository.findAll());
	}
}
//