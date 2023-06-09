package com.example.clientsservice.models;

import com.example.clientsservice.models.enums.Role;
import com.example.clientsservice.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

//
@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(length = 25, nullable = false)
    private String firstName;
    @Column(length = 25, nullable = false)
    private String secondName;
    @Column(length = 25, nullable = false, unique = true)
    private String username;
    @Column(length = 25, nullable = false)
    private String password;
    @Column(nullable = false, columnDefinition = "int(1) default 0")
    private Status status;
    @Column(nullable = false, columnDefinition = "int(1) default 0")
    private Role role;
    @Column(nullable = false)
    private String email;

    public User(Long id, String username, String password, String email) {
        this.Id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(Long id, String username, String password, String email, String firstName, String secondName) {
        this(id, username, password, email);
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
