package com.example.Haratres.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="color_product_variant")
@Data
@NoArgsConstructor
public class ColorProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private  String color;
    private double price;

    @OneToMany()
    @JsonManagedReference
    private List<SizeProductVariant> sizeProductVariants;
}
