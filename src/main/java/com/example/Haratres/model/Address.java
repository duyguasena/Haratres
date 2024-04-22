package com.example.Haratres.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="address")
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String street;
    private String addressDetail;
    private String postalCode;

    @ManyToOne()
    @JoinColumn(name="user_id",referencedColumnName = "id")
    @JsonBackReference
    private User user;

}
