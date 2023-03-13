package com.example.clientsservice.services.data;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.User;
import com.example.clientsservice.models.enums.Gender;
import com.example.clientsservice.models.enums.Role;
import com.example.clientsservice.models.enums.Status;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class ModelsSource {
//    @Bean
//    public Client client() {
//        return new Client(1, "s", "n", "p", Gender.MALE, LocalDate.now(), "e");
//    }

//    @Bean
//    public List<Client> clientList() {
//        return Arrays.asList(
//                new Client(1, "a", "a", "a", MALE, LocalDate.now(), "a"),
//                new Client(2, "b", "b", "b", FEMALE, LocalDate.now(), "b")
//        );
//    }

    @Bean
    public Account account() {
        return new Account();
    }

    @Bean
    public User user(BCryptPasswordEncoder encoder) {
        String password = encoder.encode("tester");
        User user = new User(1L, "tester", "tester", "tester", password, Status.ACTIVE, Role.USER, "u@user");
        return user;
    }

    @Bean
    public ArrayList<User> userList(BCryptPasswordEncoder encoder){
        return new ArrayList<>(Arrays.asList(
                new User(1L,"root","root", "root", encoder.encode("root"),
                        Status.ACTIVE, Role.ARCHITECTOR, "root@root.com"),
                new User(2L,"tester","tester", "tester", encoder.encode("test"),
                        Status.ACTIVE, Role.USER, "tester@tester.com")
        ));
    }
}
