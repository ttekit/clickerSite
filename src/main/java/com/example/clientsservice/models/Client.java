package com.example.clientsservice.models;

import com.example.clientsservice.Role;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//
@Entity
@Table(name="clients")
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
    private Gender gender;

    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "client")
    private Set<Phone> phones;
}
