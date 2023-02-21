package com.example.clientsservice.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//
@Entity
@Table(name = "phones")
public class Phone {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(length = 20)
    private String number;
    @ManyToOne
    private Client client;
}
