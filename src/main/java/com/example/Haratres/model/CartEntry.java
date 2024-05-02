package com.example.Haratres.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name="carts_entry")
@Data
@NoArgsConstructor

public class CartEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;
    @OneToOne
    public SizeProductVariant sizeProductVariant;
    @OneToOne
    private Cart order;
}

