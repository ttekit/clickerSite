package com.example.clientsservice.models;

import com.example.clientsservice.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    @Column(nullable = false, columnDefinition = "Decimal(10) default '0'")
    private Integer amount;
    @Column(nullable = false)
    @ToString.Exclude
    private Role role;
    @ManyToMany(mappedBy = "accounts")
    @ToString.Exclude
    private Set<Client> clients;
}

