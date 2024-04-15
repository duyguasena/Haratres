package com.example.Haratres.model;

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
    private String roles;
    private String email;
    private String password;
    public User(Long id, String roles, String email, String encode) {
        this.id=id;
        this.roles = roles;
        this.email=email;
        this.password=encode;
    }
   public User() {

   }
}
