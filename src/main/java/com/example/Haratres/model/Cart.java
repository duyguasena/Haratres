package com.example.Haratres.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="carts")
@Data
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private Date creationTime=new Date();
    private Date modifiedTime=new Date();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;




}
