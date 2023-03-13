package com.example.clientsservice.models;

import com.example.clientsservice.services.ClientService;
import com.example.clientsservice.services.data.database.ClientServiceDb;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//
@Entity
@Table(name = "address")
public class Address {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(length = 50, nullable = false)
    private String country;
    @Column(length = 50, nullable = false)
    private String region;
    @Column(length = 70, nullable = false)
    private String district;
    @Column(length = 50, nullable = false)
    private String city;
    @Column(length = 70, nullable = false)
    private String street;
    @Column(length = 70, nullable = false)
    private String house;
    @Column(length = 50, nullable = false)
    private String apartment;

    @OneToOne(mappedBy = "address")
    @ToString.Exclude
    private Client client;
}
