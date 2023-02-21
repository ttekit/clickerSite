package com.example.clientsservice.models;

import com.example.clientsservice.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//
@Entity
@Table(name = "account")
public class Account {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Integer money;
    private Role role;
    @ManyToMany
    private List<Client> clients;
}
