package com.example.Haratres.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String password;
    public User(Long id, String userName, String encode) {
        this.id=id;
        this.userName = userName;
        this.password=encode;
    }
   public User() {

   }
}
