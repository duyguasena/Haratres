package com.example.Haratres.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Table(name="size_product_variant")
@Data
@NoArgsConstructor
public class SizeProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String size;
    private String sizeCode;

    @ManyToOne()
    @JoinColumn(name="color_product_variant_id",referencedColumnName = "id")
    @JsonBackReference
    private ColorProductVariant colorProductVariant;

}
