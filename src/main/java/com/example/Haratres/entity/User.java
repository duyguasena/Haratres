package com.example.Haratres.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="users")
@Data
@Setter
@Getter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  Long id;
    private String userName;
    private String email;
    private String password;


    public User(Long id, String userName, String email, String encode) {
        this.id=id;
        this.userName = userName;
        this.email=email;
        this.password=encode;
    }

    public User() {
    }
}
