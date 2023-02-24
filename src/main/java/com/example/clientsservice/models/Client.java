package com.example.clientsservice.models;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String surname;
    @Column(length = 50, nullable = false)
    private String patronymic;
    @Column(length = 70, nullable = false, unique = true)
    private String email;
    private LocalDate birthdate;
    @Column(nullable = false)
    @ToString.Exclude
    private Gender gender;

    @OneToOne
    @ToString.Exclude
    private Address address;
    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private Set<Phone> phones;


    @ManyToMany
    @JoinTable(name = "clients_amounts",
            joinColumns = @JoinColumn(table = "clients"),
            inverseJoinColumns = @JoinColumn(table = "accounts")
    )
    @ToString.Exclude
    private Set<Account> accounts;
}
